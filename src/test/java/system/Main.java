package system;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import system.pages.LeftNavMenu;
import system.pages.MainPage;
import system.pages.TableSortSearchPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class Main {

    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    void atividade00() {
        // GIVEN
        driver = DriverManager.getDriver();
        MainPage mainPage = new MainPage();

        // WHEN
        mainPage.acessarPagina();

        // THEN
        assertEquals("Selenium Easy", mainPage.getNomeDoSite(), "O título da página está correto");

        // FINALLY
        DriverManager.endSession();
    }

    @Test
    @Disabled
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
    @Disabled
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
    @Disabled
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
    @Disabled
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

    @Test
    @Disabled
    void atividade18() {
        driver = DriverManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        try {
            driver.findElement(By.cssSelector("elementoquenaoexiste"));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getClass());
        }

        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade19() {
        driver = DriverManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            driver.findElement(By.cssSelector("#block_top_menu .submenu-container"));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getClass());
        }

        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade20() {
        driver = DriverManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

        try {
            driver.findElement(By.cssSelector("#block_top_menu .menu-content"));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getClass());
        }

        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade21() throws InterruptedException{
        driver = DriverManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions actions = new Actions(driver);

        WebElement womenMenu = driver.findElement(By.cssSelector("#block_top_menu a[title='Women']"));
        By elementNotVisibleSelector = By.cssSelector("#block_top_menu .submenu-container");

        try {
            System.out.println(driver.findElement(elementNotVisibleSelector).isDisplayed());
//            actions.moveToElement(womenMenu).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementNotVisibleSelector));
            System.out.println(driver.findElement(elementNotVisibleSelector).isDisplayed());
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getClass());
        }

        Thread.sleep(2000);
        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade22() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
        driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");

        WebElement nameInput = driver.findElement(By.id("title"));
        WebElement commentInput = driver.findElement(By.id("description"));
        WebElement submitBtn = driver.findElement(By.id("btn-submit"));
        By tempImgSelector = By.cssSelector("#submit-control img");
        By successMessage = By.id("submit-control");

        nameInput.sendKeys("esse e o nome");
        commentInput.sendKeys("esse e o comentario");
        submitBtn.click();

        wait.until(ExpectedConditions.stalenessOf(driver.findElement(tempImgSelector)));
        System.out.println("MENSAGEM SUCESSO: " + driver.findElement(successMessage).getText());

        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade23() {
        driver = DriverManager.getDriver();
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");

        By projectDescriptionSelector = By.cssSelector("#contact_form [name='comment']");
        By stateSelector = By.cssSelector("#contact_form [name='state']");
        By sendBtnSelector = By.cssSelector("[type='submit']");
        WebElement stateAlaska = driver.findElement(By.cssSelector("#contact_form [name='state'] option:nth-child(3)"));
        String descriptionText = "essa e a mais nova descricao do projeto";

        driver.findElement(projectDescriptionSelector).sendKeys(descriptionText);
        stateAlaska.click();

        assertEquals(descriptionText, driver.findElement(projectDescriptionSelector).getAttribute("value"),
                "A descrição está correta");

        assertEquals("Alaska", driver.findElement(stateSelector).getAttribute("value"),
                "O estado mostrado é Alaska");

        driver.findElement(sendBtnSelector).click();

        assertTrue(driver.findElement(projectDescriptionSelector).getAttribute("value").isEmpty(),
                "Após o clique em 'send' a descrição foi limpa");

        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade24() {
        driver = DriverManager.getDriver();
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement qualquerLinhaTabela = driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(4)"));

        assertTrue(qualquerLinhaTabela.getText().contains("Emily John"),
                "A quarta linha da tabela contém o assignee Emily John");

        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade25() {
        driver = DriverManager.getDriver();
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement tabela = driver.findElement(By.id("task-table"));
        WebElement cabecalhoTerceiraColuna = tabela.findElement(By.cssSelector("thead tr th:nth-child(3)"));
        List<WebElement> terceiraColuna = tabela.findElements(By.cssSelector("tbody tr td:nth-child(3)"));
        List<String> esperadoTerceiraColuna = Arrays.asList("John Smith", "Mike Trout", "Loblab Dan");

        assertEquals("Assignee", cabecalhoTerceiraColuna.getText(),
                "O cabeçalho da terceira coluna é 'Assignee'");

        assertAll("O conteúdo da terceira coluna está correto",
            () -> assertEquals(esperadoTerceiraColuna.get(0), terceiraColuna.get(0).getText(),
                    "A primeira linha da terceira coluna tem o valor correto"),
            () -> assertEquals(esperadoTerceiraColuna.get(1), terceiraColuna.get(1).getText(),
                    "A primeira linha da terceira coluna tem o valor correto"),
            () -> assertEquals(esperadoTerceiraColuna.get(2), terceiraColuna.get(2).getText(),
                    "A primeira linha da terceira coluna tem o valor correto")
        );

        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade26() {

        // SETUP

        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
        driver.get("https://www.seleniumeasy.com/test");

        By learnSeleniumAdd = By.cssSelector(".at-cm-no-button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(learnSeleniumAdd));
        driver.findElement(learnSeleniumAdd).click();

        // WHEN

        WebElement botaoTableMenu = driver.findElement(By.cssSelector("#navbar-brand-centered .nav > li:nth-child(3)"));
        botaoTableMenu.click();

        By botaoTableSortSearchSeletor = By.cssSelector(".dropdown-menu > li:nth-child(4)");
        wait.until(ExpectedConditions.presenceOfElementLocated(botaoTableSortSearchSeletor));
        WebElement botaoTableSortSearch = botaoTableMenu.findElement(botaoTableSortSearchSeletor);
        botaoTableSortSearch.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#example tr")));
        By seletorSearchInput = By.cssSelector("#example_filter input");
        driver.findElement(seletorSearchInput).sendKeys("London");

        By seletorMensagemShowing = By.cssSelector("#example_info");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(seletorMensagemShowing, "filtered"));

        // THEN

        int quantidadeEsperadaLinhasTabela = 7;
        int quantidadeRealLinhasTabela = driver.findElements(By.cssSelector("#example tbody tr")).size();

        assertEquals(quantidadeEsperadaLinhasTabela, quantidadeRealLinhasTabela,
                "Depois de filtrada por 'London' a tabela mostra 7 resultados");

        // FINALLY
        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade27() {
        // GIVEN
        MainPage mainPage = new MainPage();
        LeftNavMenu leftNavMenu = new LeftNavMenu();
        int quantidadeEsperadaLinhasTabela = 7;

        // WHEN
        mainPage.acessarPagina();
        TableSortSearchPage tableSortSearchPage = leftNavMenu.navegarParaTableSortSearch();
        tableSortSearchPage.pesquisarPor("London");

        // THEN
        assertEquals(
                quantidadeEsperadaLinhasTabela,
                tableSortSearchPage.getQuantidadeLinhasTabela(),
                "Depois de filtrada por 'London' a tabela mostra 7 resultados");

        // FINALLY
        DriverManager.endSession();
    }

    @Test
    @Disabled
    void atividade28() {


    }

    @Test
    @Disabled
    void atividade29() {
        System.out.println("Me mostrem o que vocês fizeram!!!");
    }
}
