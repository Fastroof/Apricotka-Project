package ua.com.apricotka.service;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class DollarRateServiceImpl {

    @Value("${link.for.usd}")
    private String linkForUSD;

    public double getRate() {
        double rate = 0;
        try {
            System.out.println(linkForUSD);
            URL url = new URL(linkForUSD);
            JSONTokener t = new JSONTokener(url.openStream());
            JSONObject root = new JSONObject(t);
            rate = Double.parseDouble(root.getString("value"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rate;
    }
}
