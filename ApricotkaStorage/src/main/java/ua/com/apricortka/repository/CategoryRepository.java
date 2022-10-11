package ua.com.apricortka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.apricortka.entity.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
