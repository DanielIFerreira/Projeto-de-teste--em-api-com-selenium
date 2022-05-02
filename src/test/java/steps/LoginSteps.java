package steps;

import io.cucumber.java.pt.Dada;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.RestUtils;

import java.util.Map;

public class LoginSteps {
    //String url = "http://localhost:8080/";

    @Dado("que tenha um payload validdo da API de Login")
    public void queTenhaUmPayloadValiddoDaAPIDeLogin() {
        LoginMap.initLogin();
        RestUtils.setBaseURI();
    }
    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
        RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
    }

    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
        LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
    }

    @Dada("que tenha um payload da API do Login com as seguintes informacoes")
    public void queTenhaUmPayloadDaAPIDoLoginComAsSeguintesInformacoes(Map<String, String> map) {
        LoginMap.initLogin();
        RestUtils.setBaseURI();
        LoginMap.getLogin().putAll(map);
    }

    @Dada("que tenha realizado o login com dados validos")
    public void queTenhaRealizadoOLoginComDadosValidos() {
        LoginMap.initLogin();
        RestUtils.setBaseURI();
        RestUtils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
        LoginMap.token = RestUtils.getResponse().jsonPath().get("token");
    }

}
