package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    String niamUrl;
    String nacmUrl;

    public Configuration() {

        try (InputStream input = new FileInputStream("config/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value
            this.niamUrl = prop.getProperty("niamUrl");
            this.nacmUrl = prop.getProperty("nacmUrl");


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getNiamUrl() {

        return niamUrl;
    }

    public String getNacmUrl() {
        return nacmUrl;
    }
}
