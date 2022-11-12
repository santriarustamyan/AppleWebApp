package pages;

import static io.restassured.RestAssured.given;

public class Requests {

    public int getStatusCode(String URL) {
        return
                given()
                        .baseUri(URL)
                        .get("")
                        .getStatusCode();
    }
}
