package ua.com.apricortka.storage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.apricortka.storage.entity.IncomingProductDetail;

@Repository
public interface IncomingProductDetailRepository extends CrudRepository<IncomingProductDetail, Long> {
    Iterable<IncomingProductDetail> findAllByProductId(Long product_id);
}
