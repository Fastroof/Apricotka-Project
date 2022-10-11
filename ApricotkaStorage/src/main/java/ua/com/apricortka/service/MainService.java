package ua.com.apricortka.service;

import org.springframework.stereotype.Service;

@Service
public interface MainService {
    String getCategories();
    String addCategory(String name);
    String updateCategory(Long id, String name);
    String deleteCategory(Long id);
}
