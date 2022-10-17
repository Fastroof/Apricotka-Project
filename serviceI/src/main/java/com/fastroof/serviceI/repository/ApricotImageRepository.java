package com.fastroof.serviceI.repository;

import com.fastroof.serviceI.entity.ApricotImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApricotImageRepository extends CrudRepository<ApricotImage, Long> {
    Iterable<ApricotImage> findAllByApricotId(Long id);
}
