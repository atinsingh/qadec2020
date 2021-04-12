package io.pragra.learning.framework.config;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/*
  SingleTon --> Only 1 object is crated
 */
public class Config {
    private static final Logger logger = LogManager.getLogger(Config.class) ;
    private static Config config;
    private Properties properties;
    private Config(){
        Path path = Paths.get("src","test","resources", "framework.properties");
        logger.info("Reading configuration file from:  {}", path.toString());
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path.toFile()));
        }catch (FileNotFoundException ex){
            logger.fatal("File [framework.properties] is not avaiable in location {} ", path.toString());
        } catch (IOException e) {
            logger.error("Something went wrong file reading file {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized static String getProperty(String key) {
        if(key==null) {
            logger.warn("Key supplied is null or invalid");
            return null;
        }
       if(config==null){
           config = new Config();
       }
       logger.debug("Searching for property with key [{}] value from file [{}] ", key, config.properties.getProperty(key) );
       return config.properties.getProperty(key);
    }
}
