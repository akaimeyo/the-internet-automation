package etc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFactory {

    Properties properties = new Properties();

    InputStream resources = getClass().getClassLoader().getResourceAsStream("config.properties");

    public String loadProperty(String property) {

        try {
            properties.load(resources);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(property);
    }

}
