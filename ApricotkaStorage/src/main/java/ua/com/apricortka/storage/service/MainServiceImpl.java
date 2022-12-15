package ua.com.apricortka.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ua.com.apricortka.storage.entity.*;
import ua.com.apricortka.storage.pojo.Available;
import ua.com.apricortka.storage.repository.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class MainServiceImpl implements MainService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final IncomingProductDetailRepository incomingProductDetailRepository;
    private final ProductImageRepository productImageRepository;

    @Autowired
    public MainServiceImpl(CategoryRepository categoryRepository,
                           ProductRepository productRepository,
                           IncomingProductDetailRepository incomingProductDetailRepository,
                           ProductImageRepository productImageRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.incomingProductDetailRepository = incomingProductDetailRepository;
        this.productImageRepository = productImageRepository;
    }

    // Categories

    @Override
    public String getCategories() {
        return categoryRepository.findAll().toString();
    }

    @Override
    public String addCategory(String name) {
        if (name == null || "".equals(name)) {
            return "Неправильна назва категорії";
        } else if (categoryRepository.findByName(name).isPresent()) {
            return "Така категорія вже існує";
        }
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return category.toString();
    }

    @Override
    public String updateCategory(Long id, String name) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (name == null || "".equals(name)) {
            return "Неправильна назва категорії";
        } else if (categoryOptional.isPresent()) {
            Optional<Category> categoryOptionalByName = categoryRepository.findByName(name);
            if (categoryOptionalByName.isPresent() && !categoryOptionalByName.get().getName().equals(categoryOptional.get().getName())) {
                return "Така категорія вже існує";
            } else {
                Category category = categoryOptional.get();
                category.setName(name);
                categoryRepository.save(category);
                return category.toString();
            }
        }
        return "Не існує категорії з таким id";
    }

    @Override
    public String deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Категорія успішно видалена";
        }
        return "Не існує категорії з таким id";
    }

    // Products

    @Override
    public String getProducts() {
        return productRepository.findAll().toString();
    }

    @Override
    public Iterable<Product> getProductsWithoutIncoming() {
        return productRepository.findAll();
    }

    @Override
    public String addProduct(Long categoryId, String name, Double price, String info) {
        if (name == null || "".equals(name)) {
            return "Неправильна назва товару";
        } else if (price == null) {
            return "Не задана ціна";
        } else if (productRepository.findByName(name).isPresent()) {
            return "Товар вже існує";
        }

        Product product = new Product();
        product.setName(name);
        product.setCategoryId(categoryId);
        product.setPrice(price);
        product.setInfo(info);
        productRepository.save(product);
        return product.toString();
    }

    @Override
    public String updateProduct(Long id, Long categoryId, String name, Double price, String info) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (name == null || "".equals(name)) {
            return "Неправильна назва товару";
        } else if (price == null) {
            return "Не задана ціна";
        } else if (productOptional.isPresent()) {
            Optional<Product> productOptionalByName = productRepository.findByName(name);
            if (productOptionalByName.isPresent() && !productOptionalByName.get().getName().equals(productOptional.get().getName())) {
                return "Такий товар вже існує";
            } else {
                Product product = productOptional.get();
                product.setName(name);
                product.setCategoryId(categoryId);
                product.setPrice(price);
                product.setInfo(info);
                productRepository.save(product);
                return product.toString();
            }
        }
        return "Не існує товару з таким id";
    }

    @Override
    public String deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Товар успішно видалена";
        }
        return "Не існує товару з таким id";
    }

    @Override
    public String getAllProductImages() {
        return productImageRepository.findAll().toString();
    }

    @Override
    public String getIncomings() {
        String result = StreamSupport.stream(incomingProductDetailRepository.findAll().spliterator(), true)
                .map(IncomingProductDetail::toString)
                .collect(Collectors.joining(","));
        return "[" + result + "]";
    }

    @Override
    public ProductWithImages getProductWithImagesById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        ProductWithImages productWithImages = new ProductWithImages();
        productWithImages.setId(product.getId());
        productWithImages.setCategoryId(product.getCategoryId());
        productWithImages.setName(product.getName());
        productWithImages.setInfo(product.getInfo());
        productWithImages.setPrice(product.getPrice());
        List<String> images = new ArrayList<>();
        for (ProductImage productImage: productImageRepository.findAllByProductId(id)) {
            images.add(productImage.getFile());
        }
        productWithImages.setImages(images);
        return productWithImages;
    }

    @Override
    public String getProductImages(Long id) {
        return productImageRepository.findAllByProductId(id).toString();
    }

    // Incoming Product Detail

    @Override
    public String getIncomingByProductId(Long productId) {
        return incomingProductDetailRepository.findAllByProductId(productId).toString();
    }

    @Override
    @Transactional
    public String addIncoming(Long productId, String supplier, Double initial_price, Long quantity) {
        if (productId == null) {
            return "Товар не заданий";
        }
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()) {
            return "Товар не існує";
        } else if (initial_price == null) {
            return "Не задана ціна";
        } else if (quantity == null) {
            return "Не задана кількість";
        }
        Product product = productOptional.get();
        IncomingProductDetail incoming = new IncomingProductDetail();
        incoming.setInitial_price(initial_price);
        incoming.setQuantity(quantity);
        incoming.setSupplier(supplier);
        incoming.setTimestamp(new Timestamp(System.currentTimeMillis()));
        incoming.setProduct(product);
        product.getIncomingProductDetails().add(incoming);
        productRepository.save(product);
        return incoming.toString();
    }

    @Override
    public String updateIncoming(Long id, Long quantity) {
        if (quantity == null) {
            return "Не задана кількість";
        }
        Optional<IncomingProductDetail> incomingOptional = incomingProductDetailRepository.findById(id);
        if (incomingOptional.isPresent()) {
            IncomingProductDetail incoming = incomingOptional.get();
            incoming.setQuantity(quantity);
            incomingProductDetailRepository.save(incoming);
            return incoming.toString();
        }
        return "Не існує завозу з таким id";
    }

    @Override
    public String deleteIncoming(Long id) {
        Optional<IncomingProductDetail> incOpt = incomingProductDetailRepository.findById(id);
        if (incOpt.isPresent()) {
            IncomingProductDetail inc = incOpt.get();
            Product product = inc.getProduct();
            product.getIncomingProductDetails().remove(inc);
            productRepository.save(product);
            incomingProductDetailRepository.deleteById(id);
            return "Завоз успішно видалена";
        }
        return "Не існує завозу з таким id";
    }

    @Value("${link.to.service.messenger}")
    private String linkToMessenger;
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean sendMessage(String mail, String title, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> map = new HashMap<>();
        map.put("recipient", mail);
        map.put("subject", title);
        map.put("msgBody", body);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = this.restTemplate.postForEntity(linkToMessenger+"sendMail", entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return "Mail Sent Successfully...".equals(response.getBody());
        }
        return false;
    }

    @Override
    public String getHowManyByProductId(Long productId) throws Exception {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()) {
            throw new Exception("Товар " + productId +" не існує");
        }
        long inq = 0;
        for (IncomingProductDetail incoming: productOptional.get().getIncomingProductDetails()) {
            inq += incoming.getQuantity();
        }
        return "{\"q\": "+inq+"}";
    }

    @Override
    public List<Available> getHowManyAll() {
        Iterable<Product> products = productRepository.findAll();
        List<Available> availables = new ArrayList<>();
        products.forEach(product -> {
            Available available = new Available();
            available.setProductId(product.getId());
            long inq = 0;
            for (IncomingProductDetail incoming: product.getIncomingProductDetails()) {
                inq += incoming.getQuantity();
            }
            available.setQ(inq);
            availables.add(available);
        });
        return availables;
    }

}
