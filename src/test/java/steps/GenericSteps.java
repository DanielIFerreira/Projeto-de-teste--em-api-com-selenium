package steps;

import io.cucumber.java.pt.Entao;
import maps.FilmesMap;
import org.junit.Assert;
import utils.RestUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GenericSteps {
    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUtils.getResponse().getStatusCode());
    }

    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value) {
        Assert.assertEquals(value, RestUtils.getResponse().jsonPath().get(key));
    }

    @Entao("valido que rece uma lista vazia no response")
    public void validoQueReceUmaListaVaziaNoResponse() {
        List<String> list = new ArrayList<>(0);
        Assert.assertEquals(list, RestUtils.getResponse().jsonPath().get());
    }

}
