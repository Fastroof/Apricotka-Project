package com.fastroof.serviceG.controller;

import com.fastroof.serviceG.entity.Gallery;
import com.fastroof.serviceG.entity.GalleryImage;
import com.fastroof.serviceG.service.GalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GalleryRestController {

    private final GalleryServiceImpl galleryService;
    @Autowired
    public GalleryRestController(GalleryServiceImpl galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("")
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

    @PostMapping("/new/gallery")
    public String newGallery(String galleryName) {
        return galleryService.addGallery(galleryName);
    }

    @PostMapping("/new/image")
    public String newGalleryImage(Long galleryId, String linkToImage) {
        return galleryService.addGalleryImage(galleryId, linkToImage);
    }

    @PutMapping("/gallery/{id}")
    public String updateGallery(@PathVariable Long id, String galleryName) {
        return galleryService.updateGallery(id, galleryName);
    }

    @PutMapping("/image/{id}")
    public String updateGalleryImage(@PathVariable Long id, Long galleryId, String linkToImage) {
        return galleryService.updateGalleryImage(id, galleryId, linkToImage);
    }

    @DeleteMapping("/gallery/{id}")
    public String deleteGallery(@PathVariable Long id) {
        return galleryService.deleteGallery(id);
    }

    @DeleteMapping("/image/{id}")
    public String deleteGalleryImage(@PathVariable Long id) {
        return galleryService.deleteGalleryImage(id);
    }
}
