package ua.com.apricortka.storage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.apricortka.storage.entity.ProductImage;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {
    Iterable<ProductImage> findAllByProductId(Long product_id);
}
