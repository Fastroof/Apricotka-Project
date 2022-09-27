package ua.com.apricotka.service;

import org.json.JSONArray;
import org.json.JSONTokener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    public static Iterable<Object> parseJson(String link) {
        List<Object> list = new ArrayList<>();
        try {
            URL url = new URL(link);
            JSONTokener t = new JSONTokener(url.openStream());
            JSONArray jsonArray = new JSONArray(t);
            list = jsonArray.toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
