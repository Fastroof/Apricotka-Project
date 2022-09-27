package com.fastroof.serviceG.controller;

import com.fastroof.serviceG.entity.Gallery;
import com.fastroof.serviceG.entity.GalleryImage;
import com.fastroof.serviceG.service.GalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api}")
public class GalleryController {

    private final GalleryServiceImpl galleryService;
    @Autowired
    public GalleryController(GalleryServiceImpl galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/")
    public String index() {
        return "Слава Україні! Я сервіс галереї";
    }

    @GetMapping("/gallery")
    public Iterable<Gallery> gallery() {
        return galleryService.getAllGallery();
    }

    @GetMapping("/gallery-images")
    public Iterable<GalleryImage> galleryImages() {
        return galleryService.getAllGalleryImages();
    }
}
