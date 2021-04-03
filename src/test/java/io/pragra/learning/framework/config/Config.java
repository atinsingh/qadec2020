package io.pragra.learning.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/*
  SingleTon --> Only 1 object is crated
 */
public class Config {
    private static Config config;
    private Properties properties;
    private Config(){
        Path path = Paths.get("src","test","resources","framework.properties");
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Object getProperty(String key) {
       if(config==null){
           config = new Config();
       }
       return config.properties.getProperty(key);
    }
}
