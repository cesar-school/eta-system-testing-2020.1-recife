package system;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import system.helpers.DriverManager;
import java.util.List;

class Main {

    private WebDriver driver;

    @Test
    void atividade13() {
        driver = DriverManager.getDriver();
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");

        WebElement formulario = driver.findElement(By.id("contact_form"));
        WebElement firstName = formulario.findElement(By.cssSelector("[name='first_name']"));
        WebElement hostingYes = formulario.findElement(By.cssSelector(".form-group .radio input"));
        WebElement projectDescription = formulario.findElement(By.cssSelector("[name='comment']"));
        WebElement sendBtn = formulario.findElement(By.cssSelector("[type='submit']"));
        WebElement stateSeletor = formulario.findElement(By.cssSelector("[name='state']"));
        WebElement stateAlaska = formulario.findElement(By.cssSelector("[name='state'] option:nth-child(3)"));

        firstName.sendKeys("meu nome");
        projectDescription.sendKeys("essa e a mais nova descricao do projeto");
        hostingYes.click();
        stateSeletor.sendKeys("Georgia");
        stateAlaska.click();
        sendBtn.click();

        DriverManager.endSession();
    }

    @Test
    void atividade14() {
        driver = DriverManager.getDriver();
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement qualquerLinhaTabela = driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(4)"));
        System.out.println(qualquerLinhaTabela.getText());

        DriverManager.endSession();
    }

    @Test
    void atividade15() {
        driver = DriverManager.getDriver();
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement tabela = driver.findElement(By.id("task-table"));
        WebElement cabecalhoTerceiraColuna = tabela.findElement(By.cssSelector("thead tr th:nth-child(3)"));
        List<WebElement> corpoTerceiraColuna = tabela.findElements(By.cssSelector("tbody tr td:nth-child(3)"));

        System.out.println("CABECALHO: " + cabecalhoTerceiraColuna.getText());
        for (WebElement nomes : corpoTerceiraColuna) {
            System.out.println(nomes.getText());
        }

        DriverManager.endSession();
    }

    @Test
    void atividade16() {
        driver = DriverManager.getDriver();
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement botaoFilter = driver.findElement(By.cssSelector(".filterable .panel-heading button"));
        WebElement areaFiltros = driver.findElement(By.cssSelector(".filterable .filters"));
        WebElement filtroUsername = areaFiltros.findElement(By.cssSelector("th:nth-child(2) input"));
        WebElement filtroLastName = areaFiltros.findElement(By.cssSelector("th:nth-child(4) input"));

        botaoFilter.click();
        filtroUsername.sendKeys("jaco");
        filtroLastName.sendKeys("k");

        WebElement primeiraLinhaFiltrada =
                driver.findElement(By.cssSelector(".filterable table tbody tr:not([style='display: none;'])"));

        System.out.println(primeiraLinhaFiltrada.getText());

        DriverManager.endSession();
    }

    @Test
    void atividade17() {
        driver = DriverManager.getDriver();
        driver.get("https://www.cesar.school");

        WebElement docBody = driver.findElement(By.tagName("body"));
        WebElement seuNome = driver.findElement(By.cssSelector("[name='NomeCompleto']"));
        List<WebElement> menuPrincipalLinksElementos = docBody.findElements(By.cssSelector("div.main-navigation > ul > li"));
        WebElement subMenuSchool = driver.findElement(By.cssSelector("div.main-navigation > ul > li:nth-child(2) > ul"));
        WebElement botaoScrollTop = driver.findElement(By.id("ast-scroll-top"));

        for (WebElement linkElement : menuPrincipalLinksElementos){
            System.out.print(linkElement.findElement(By.className("menu-text")).getText() + ": ");
            System.out.println(linkElement.findElement(By.className("menu-link")).getAttribute("href"));
        }

        //isDisplayed
        System.out.println("O sub menu do menu School está visível? " + subMenuSchool.isDisplayed());

        //isEnabled
        System.out.println("O botão scroll top está visível? " + botaoScrollTop.isDisplayed());
        System.out.println("O botão scroll top está ativado? " + botaoScrollTop.isEnabled());

        //sendKeys
        docBody.sendKeys(Keys.CONTROL, Keys.END);
        seuNome.sendKeys("LALALALALLA");

        //isEnabled
        System.out.println("O botão scroll top está visível depois que foi para o final da página? " + botaoScrollTop.isDisplayed());
        System.out.println("O botão scroll top está ativado depois que foi para o final da página? " + botaoScrollTop.isEnabled());

        DriverManager.endSession();
    }


}
