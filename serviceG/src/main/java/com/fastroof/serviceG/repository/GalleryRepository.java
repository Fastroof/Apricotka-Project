package com.fastroof.serviceG.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fastroof.serviceG.entity.Gallery;

@Repository
public interface GalleryRepository extends CrudRepository<Gallery, Long> {
}
