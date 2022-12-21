package utils;

import java.text.Normalizer;
import java.util.Map;

public class Utils {

    public static String normalizeInput(String input){
        String normalizedString = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalizedString.replaceAll("[^\\p{ASCII}]", "");
    }

    public static String buildParams(Map<String, String> params){
        StringBuilder response = new StringBuilder();
        for (String data : params.keySet()){
            response.append("&").append(data).append("=").append(params.get(data));
        }
        return response.toString().substring(1);
    }

}