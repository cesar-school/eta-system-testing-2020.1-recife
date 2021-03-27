package system.stepDefinitions;

import io.cucumber.java.en.Given;

public class exemploStepDefinition {

    @Given("a lista de compras contém {int} itens")
    public void aListaDeComprasContemItens(int quantidade) {
        System.out.println("QUANTIDADE: " + quantidade);
    }
}
