package steps;

import io.cucumber.java.pt.Dada;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import org.junit.Assert;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class CategoriaSteps {

    Map<String, String> header = new HashMap<>();

    @Dada("que tenha um playload da API de Categoria")
    public void queTenhaUmPlayloadDaAPIDeCategoria() {
        RestUtils.setBaseURI();
        header.put("Authorization","Bearer " + LoginMap.token);
    }

    @Quando("realizo uma requisicao do tipo GET de Categoria")
    public void realizoUmaRequisicaoDoTipoGETDeCategoria() {
       RestUtils.get(header, "categorias");

    }

    @Dado("que altere o campo {string} para {string} do header de Login")
    public void queAltereOCampoParaDoHeaderDeLogin(String key, String value) {
        header.put(key, value);

    }

    @Entao("valido que recebo um status {int} no response")
    public void validoQueReceboUmStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUtils.getResponse().getStatusCode());

    }


}
