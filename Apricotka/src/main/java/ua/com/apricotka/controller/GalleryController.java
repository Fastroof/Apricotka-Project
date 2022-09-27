package ua.com.apricotka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.apricotka.service.GalleryServiceImpl;

@Controller
public class GalleryController {

    private final GalleryServiceImpl galleryService;

    @Autowired
    public GalleryController(GalleryServiceImpl galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/gallery")
    public String showGalleryPage(ModelMap model) {
        model.addAttribute("galleryGroups", galleryService.getGallery());
        model.addAttribute("galleryImages", galleryService.getGalleryImages());
        return "gallery";
    }
}