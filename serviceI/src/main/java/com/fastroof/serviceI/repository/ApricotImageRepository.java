package com.fastroof.serviceI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fastroof.serviceI.entity.ApricotImage;

@Repository
public interface ApricotImageRepository extends CrudRepository<ApricotImage, Long> {
}
