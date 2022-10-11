package ua.com.apricortka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.apricortka.entity.IncomingProductDetail;

@Repository
public interface IncomingProductDetailRepository extends CrudRepository<IncomingProductDetail, Long> {
}
