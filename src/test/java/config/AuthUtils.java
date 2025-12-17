package config;

import static io.restassured.RestAssured.*;

public class AuthUtils {

    public static String getToken() {

        return given()
                .contentType("application/json")
                .body("""
                {
                  "email": "ahemdnaim123@gmail.com",
                  "password": "ahemdnaim123@gmail.com"
                }
            """)
                .post("http://localhost:8002/api/v1/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
