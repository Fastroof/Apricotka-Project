package ua.com.apricotka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static ua.com.apricotka.service.JsonHelper.parseJson;

@Service
public class GalleryServiceImpl {
    @Value("${link.for.gallery}")
    private String linkForGallery;
    @Value("${link.for.gallery-images}")
    private String linkForGalleryImages;

    public Iterable<Object> getGallery() {
        System.out.println(linkForGallery);
        return parseJson(linkForGallery);
    }

    public Iterable<Object> getGalleryImages() {
        System.out.println(linkForGalleryImages);
        return parseJson(linkForGalleryImages);
    }
}
