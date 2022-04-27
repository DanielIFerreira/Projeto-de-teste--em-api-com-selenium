package plataformaFilmes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlataformaFilmesTeste {
    static String token;

    @Test
    public void valorLogin(){
        RestUtils.setBaseURI();
        String json = "{" +
                "  \"email\": \"aluno@email.com\"," +
                "  \"senha\": \"123456\"" +
                "}";

        Response response = RestUtils.post(json, ContentType.JSON, "auth");
        assertEquals(200, response.statusCode());
        String token = response.jsonPath().get("token");
        //System.out.println(token);

    }

    //Utilizando Map para realizar o login na aplicação/ É as mesma coisa de método de cima
    @BeforeAll
    //@Test
    public static void validarLoginMap(){
        RestUtils.setBaseURI();
        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha", "123456");

        Response response = RestUtils.post(map, ContentType.JSON, "auth");
        assertEquals( 200, response.statusCode());
        token = response.jsonPath().get("token");
        //System.out.println(token);
    }

    @Test
    public void validarConsultaCategorias(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);
        Response response = RestUtils.get(header, "categorias");
        assertEquals(200, response.statusCode());
        //System.out.println(response.jsonPath().get().toString());

        var resposta = response.jsonPath().get("tipo[2]");
        assertEquals("Terror", resposta);
        //System.out.println(resposta);

        var respostaTipo = response.jsonPath().get("tipo");

        List<String> listTipo = response.jsonPath().get("tipo");
        listTipo.contains("Crime");
        assertTrue(listTipo.contains("Crime"));
        //System.out.println(respostaTipo);

    }
}
