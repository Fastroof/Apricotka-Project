package ua.com.apricortka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.apricortka.entity.Category;
import ua.com.apricortka.repository.CategoryRepository;

import java.util.Optional;

@Service
public class MainServiceImpl implements MainService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public MainServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String getCategories() {
        return categoryRepository.findAll().toString();
    }

    @Override
    public String addCategory(String name) {
        if (name == null || "".equals(name)) {
            return "Неправильне ім'я групи";
        } else if (categoryRepository.findByName(name).isPresent()) {
            return "Така група вже існує";
        }
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return category.toString();
    }

    @Override
    public String updateCategory(Long id, String name) {
        if (name == null || "".equals(name)) {
            return "Неправильне ім'я групи";
        } else if (categoryRepository.findByName(name).isPresent()) {
            return "Така група вже існує";
        }
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(name);
            categoryRepository.save(category);
            return category.toString();
        }
        return "Не існує групи с таким id";
    }

    @Override
    public String deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Група успішно видалена";
        }
        return "Не існує групи с таким id";
    }
}
