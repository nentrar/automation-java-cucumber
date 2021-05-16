package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    String sekretnaUrl;
    String testujUrl;

    public Configuration() {

        try (InputStream input = new FileInputStream("config/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value
            this.sekretnaUrl = prop.getProperty("sekretnaUrl");
            this.testujUrl = prop.getProperty("testujUrl");


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getSekretnaUrl() {

        return sekretnaUrl;
    }

    public String getTestujUrl() {

        return testujUrl;
    }
}
