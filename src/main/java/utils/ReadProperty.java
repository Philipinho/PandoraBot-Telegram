package utils;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {
    private static final Properties props = new Properties();

    static {
        try{
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("bot.properties");
            props.load(inputStream);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return props.getProperty(key);
    }

}
