package com.fastroof.serviceI.service;

import com.fastroof.serviceI.entity.Apricot;
import com.fastroof.serviceI.entity.ApricotImage;
import com.fastroof.serviceI.repository.ApricotImageRepository;
import com.fastroof.serviceI.repository.ApricotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
