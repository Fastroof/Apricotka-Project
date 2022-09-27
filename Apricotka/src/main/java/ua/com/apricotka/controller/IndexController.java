package ua.com.apricotka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.apricotka.service.DollarRateServiceImpl;
import ua.com.apricotka.service.IndexServiceImpl;

@Controller
public class IndexController {

    private final IndexServiceImpl indexService;
    private final DollarRateServiceImpl dollarRateServiceImpl;

    @Autowired
    public IndexController(IndexServiceImpl indexService, DollarRateServiceImpl dollarRateServiceImpl) {
        this.indexService = indexService;
        this.dollarRateServiceImpl = dollarRateServiceImpl;
    }

    @GetMapping("/")
    public String showIndexPage(ModelMap model) {
        model.addAttribute("apricots", indexService.getApricots());
        model.addAttribute("apricotImages", indexService.getApricotImages());
        model.addAttribute("dollarRate", dollarRateServiceImpl.getRate());
        return "index";
    }
}
