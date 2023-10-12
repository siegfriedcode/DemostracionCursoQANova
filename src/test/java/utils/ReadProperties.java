package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    public static Properties readFromConfig(String nameFile){
        String propFileName=nameFile;
        Properties properties=new Properties();
        InputStream inputStream= ReadProperties.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream!=null){
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                System.out.println("No se pudo encontrar el archivo properties "+propFileName);
            }
        }else{
            System.out.println("No se pudo encontrar el archivo properties "+propFileName);
        }
        return properties;
    }
}
