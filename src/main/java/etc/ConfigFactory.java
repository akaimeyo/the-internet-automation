package etc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFactory {

    String path = "/home/piotr/IdeaProjects/the-internet-automation/src/main/resources/config.properties";

    Properties properties = new Properties();

    public String loadProperty(String property) {

        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return (String) properties.get(property);
    }

}
