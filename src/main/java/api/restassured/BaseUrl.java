package api.restassured;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseUrl {

    public class FunctionalTest {

        @Before
        public void setup() {

            String basePath = System.getProperty("server.base");
            if(basePath==null){
                basePath = "/posts/";
            }
            RestAssured.basePath = basePath;

            String baseHost = System.getProperty("server.host");
            if(baseHost==null){
                baseHost = "https://jsonplaceholder.typicode.com";
            }
            RestAssured.baseURI = baseHost;

        }

    }
}
