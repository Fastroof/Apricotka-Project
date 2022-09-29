package com.fastroof.serviceI.controller;

import com.fastroof.serviceI.entity.Apricot;
import com.fastroof.serviceI.entity.ApricotImage;
import com.fastroof.serviceI.service.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api}")
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

    @GetMapping("/apricot-images")
    public Iterable<ApricotImage> apricotImages() {
        return indexService.getAllApricotImages();
    }
}
