package com.fastroof.serviceG.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fastroof.serviceG.entity.GalleryImage;

@Repository
public interface GalleryImageRepository extends CrudRepository<GalleryImage, Long> {
    void deleteAllByGroupId(Long groupId);
}
