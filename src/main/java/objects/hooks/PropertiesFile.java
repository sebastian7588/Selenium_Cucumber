package objects.hooks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }

    public String getProperties (String property){
        PropertiesFile propertiesFile = new PropertiesFile();
        Properties prop = propertiesFile.loadPropertiesFile("config.properties");
        String envProperty = prop.getProperty(property);
        return envProperty;
    }
}
