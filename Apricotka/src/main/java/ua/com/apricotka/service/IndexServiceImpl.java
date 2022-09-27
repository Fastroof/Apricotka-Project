package ua.com.apricotka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static ua.com.apricotka.service.JsonHelper.parseJson;

@Service
public class IndexServiceImpl {
    @Value("${link.for.apricots}")
    private String linkForApricots;
    @Value("${link.for.apricot-images}")
    private String linkForApricotImages;

    public Iterable<Object> getApricots() {
        System.out.println(linkForApricots);
        return parseJson(linkForApricots);
    }

    public Iterable<Object> getApricotImages() {
        System.out.println(linkForApricotImages);
        return parseJson(linkForApricotImages);
    }
}
