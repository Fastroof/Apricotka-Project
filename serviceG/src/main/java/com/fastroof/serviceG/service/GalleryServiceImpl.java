package com.fastroof.serviceG.service;

import com.fastroof.serviceG.entity.Gallery;
import com.fastroof.serviceG.entity.GalleryImage;
import com.fastroof.serviceG.repository.GalleryImageRepository;
import com.fastroof.serviceG.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public String addGallery(String galleryName) {
        if (galleryName != null && !"".equals(galleryName)) {
            Gallery gallery = new Gallery();
            gallery.setGroupName(galleryName);
            galleryRepository.save(gallery);
            return gallery.toString();
        }
        return "Неправильний параметр назви групи";
    }

    public String addGalleryImage(Long galleryId, String linkToImage) {
        if (linkToImage == null || "".equals(linkToImage)) {
            return "Неправильне посилання на зображення";
        } else if (galleryId == null || !galleryRepository.findById(galleryId).isPresent()) {
            return "Неправильний ID групи, або він не заданий";
        }
        GalleryImage galleryImage = new GalleryImage();
        galleryImage.setGroupId(galleryId);
        galleryImage.setFile(linkToImage);
        galleryImageRepository.save(galleryImage);
        return galleryImage.toString();
    }

    public String updateGallery(Long id, String galleryName) {
        if (galleryName != null && !"".equals(galleryName)) {
            Optional<Gallery> galleryOptional = galleryRepository.findById(id);
            if (galleryOptional.isPresent()) {
                Gallery gallery = galleryOptional.get();
                gallery.setGroupName(galleryName);
                galleryRepository.save(gallery);
                return gallery.toString();
            } else {
                return "Неіснуючий ID групи";
            }
        }
        return "Неправильний параметр назви групи";
    }

    public String updateGalleryImage(Long id, Long galleryId, String linkToImage) {
        if (linkToImage == null || "".equals(linkToImage)) {
            return "Неправильне посилання на зображення";
        } else if (galleryId == null || !galleryRepository.findById(galleryId).isPresent()) {
            return "Неправильний ID групи, або він не заданий";
        } else if (galleryImageRepository.findById(id).isPresent()) {
            GalleryImage galleryImage = galleryImageRepository.findById(id).get();
            galleryImage.setGroupId(galleryId);
            galleryImage.setFile(linkToImage);
            galleryImageRepository.save(galleryImage);
            return galleryImage.toString();
        }
        return "Не знайдено такого зображення";
    }

    @Transactional
    public String deleteGallery(Long id) {
        Optional<Gallery> galleryOptional = galleryRepository.findById(id);
        if (galleryOptional.isPresent()) {
            Gallery gallery = galleryOptional.get();
            galleryImageRepository.deleteAllByGroupId(gallery.getId());
            galleryRepository.delete(gallery);
            return "Успішно видалено групу та всі зображення пов'язані з нею";
        }
        return "Неправильний ID групи, або він не заданий";
    }

    public String deleteGalleryImage(Long id) {
        Optional<GalleryImage> galleryImageOptional = galleryImageRepository.findById(id);
        if (galleryImageOptional.isPresent()) {
            galleryImageRepository.delete(galleryImageOptional.get());
            return "Успішно видалено зображення";
        }
        return "Неправильний ID зображення, або він не заданий";
    }
}
