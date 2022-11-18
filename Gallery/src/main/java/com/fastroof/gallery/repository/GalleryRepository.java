package com.fastroof.gallery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fastroof.gallery.entity.Gallery;

@Repository
public interface GalleryRepository extends CrudRepository<Gallery, Long> {
}
