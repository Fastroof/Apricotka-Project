package ua.com.apricortka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.apricortka.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
