package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    static Properties properties = new Properties();

    public static String getProperties(String param) {
        if(properties.toString().equals("{}"))
            initProperties();
        return properties.getProperty(param);
    }

    private static void initProperties() {
        String target = System.getProperty("target", "prod");
        String path = String.format("src/test/resources/%s.properties", target);
        try(FileReader fileReader = new FileReader(path)){
            properties.load(fileReader);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
