package com.fastroof.serviceG.service;

import com.fastroof.serviceG.entity.Gallery;
import com.fastroof.serviceG.entity.GalleryImage;
import com.fastroof.serviceG.repository.GalleryImageRepository;
import com.fastroof.serviceG.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryServiceImpl {
    private final GalleryRepository galleryRepository;
    private final GalleryImageRepository galleryImageRepository;

    @Autowired
    public GalleryServiceImpl(GalleryRepository galleryRepository, GalleryImageRepository galleryImageRepository) {
        this.galleryRepository = galleryRepository;
        this.galleryImageRepository = galleryImageRepository;
    }

    public Iterable<Gallery> getAllGallery() {
        return galleryRepository.findAll();
    }

    public Iterable<GalleryImage> getAllGalleryImages() {
        return galleryImageRepository.findAll();
    }
}
