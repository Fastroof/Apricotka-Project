package ua.com.apricotka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.apricotka.service.IndexServiceImpl;

@Controller
public class IndexController {

    private final IndexServiceImpl indexService;

    @Autowired
    public IndexController(IndexServiceImpl indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/")
    public String showIndexPage(ModelMap model) {
        model.addAttribute("apricots", indexService.getApricots());
        model.addAttribute("apricotImages", indexService.getApricotImages());
        model.addAttribute("dollarRate", 1);
        return "index";
    }
}
