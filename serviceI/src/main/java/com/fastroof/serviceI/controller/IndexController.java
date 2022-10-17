package com.fastroof.serviceI.controller;

import com.fastroof.serviceI.entity.Apricot;
import com.fastroof.serviceI.entity.ApricotImage;
import com.fastroof.serviceI.entity.ApricotWithImages;
import com.fastroof.serviceI.service.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IndexController {

    private final IndexServiceImpl indexService;
    @Autowired
    public IndexController(IndexServiceImpl indexService) {
        this.indexService = indexService;
    }

    @GetMapping("")
    public String index() {
        return "Слава Україні! Я сервіс абрикосів";
    }

    @GetMapping("/apricots")
    public Iterable<Apricot> apricots() {
        return indexService.getAllApricots();
    }

    @GetMapping("/apricots-images")
    public Iterable<ApricotImage> apricotImages() {
        return indexService.getAllApricotImages();
    }

    @GetMapping("/apricot-with-images/{id}")
    public ApricotWithImages getApricotWithImages(@PathVariable Long id) {
        return indexService.getApricotWithImagesById(id);
    }

    @GetMapping("/apricot-images/{id}")
    public Iterable<ApricotImage> getApricotImages(@PathVariable Long id) {
        return indexService.getApricotImagesByApricotId(id);
    }
}
