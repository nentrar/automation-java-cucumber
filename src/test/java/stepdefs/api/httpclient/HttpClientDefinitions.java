package stepdefs.api.httpclient;

import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

public class HttpClientDefinitions {

    static final Logger log = Logger.getLogger(HttpClientDefinitions.class.getName());

    @Given("^posts information has been taken from API$")
    public void get_posts_information() throws Exception {


        log.info("Get posts from the");
    }

}
