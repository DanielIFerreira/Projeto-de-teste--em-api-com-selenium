package plataformaFilmes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTeste {
    static String token;
    public static Response post(Object json, ContentType contentType, String endpoint){
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();

    }

    @Test
    public void valorLogin(){
        RestAssured.baseURI = "http://localhost:8080/";

        String json = "{" +
                "  \"email\": \"aluno@email.com\"," +
                "  \"senha\": \"123456\"" +
                "}";

        Response response = post(json, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        String token = response.jsonPath().get("token");
        System.out.println(token);

    }

    //Utilizando Map para realizar o login na aplicação/ É as mesma coisa de método de cima
    @BeforeAll
    //@Test
    public static void validarLoginMap(){
        RestAssured.baseURI = "http://localhost:8080/";
        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha", "123456");

        Response response = post(map, ContentType.JSON, "auth");

        assertEquals( 200, response.statusCode());
        token = response.jsonPath().get("token");
        System.out.println(token);
    }

    @Test
    public void validarConsultaCategorias(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);

        Response response = get(header, "categorias");

        assertEquals(200, response.statusCode());

         System.out.println(response.jsonPath().get().toString());
    }

    private Response get(Map<String, String> header, String endpoint) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint)
                .thenReturn();
    }

}