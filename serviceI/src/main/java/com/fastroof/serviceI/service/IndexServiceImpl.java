package com.fastroof.serviceI.service;

import com.fastroof.serviceI.entity.Apricot;
import com.fastroof.serviceI.entity.ApricotImage;
import com.fastroof.serviceI.entity.ApricotWithImages;
import com.fastroof.serviceI.repository.ApricotImageRepository;
import com.fastroof.serviceI.repository.ApricotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexServiceImpl {

    private final ApricotRepository apricotRepository;
    private final ApricotImageRepository apricotImageRepository;

    @Autowired
    public IndexServiceImpl(ApricotRepository apricotRepository, ApricotImageRepository apricotImageRepository) {
        this.apricotRepository = apricotRepository;
        this.apricotImageRepository = apricotImageRepository;
    }

    public Iterable<Apricot> getAllApricots() {
        return apricotRepository.findAll();
    }

    public Iterable<ApricotImage> getAllApricotImages() {
        return apricotImageRepository.findAll();
    }

    public Iterable<ApricotImage> getApricotImagesByApricotId(Long id) {
        return apricotImageRepository.findAllByApricotId(id);
    }

    public ApricotWithImages getApricotWithImagesById(Long id) {
        Apricot apricot = apricotRepository.findById(id).orElse(null);
        if (apricot == null) {
           return null;
        }
        ApricotWithImages apricotWithImages = new ApricotWithImages();
        apricotWithImages.setId(apricot.getId());
        apricotWithImages.setName(apricot.getName());
        apricotWithImages.setInfo(apricot.getInfo());
        apricotWithImages.setPrice(apricot.getPrice());
        List<String> images = new ArrayList<>();
        for (ApricotImage apricotImage: getApricotImagesByApricotId(id)) {
            images.add(apricotImage.getFile());
        }
        apricotWithImages.setImages(images);
        return apricotWithImages;
    }
}
