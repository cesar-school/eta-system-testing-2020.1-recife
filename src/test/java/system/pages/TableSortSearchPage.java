package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class TableSortSearchPage {

    /*
     Representação
     */

    private WebDriver driver;
    private WebDriverWait wait;

    private By todasLinhasTabelaSeletor = By.cssSelector("#example tr");
    private By searchInputSeletor = By.cssSelector("#example_filter input");
    private By mensagemShowingSeletor = By.cssSelector("#example_info");
    private By linhasCorpoTabelaSeletor = By.cssSelector("#example tbody tr");

    /*
     Serviços
     */

    public TableSortSearchPage() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

    public void pesquisarPor(String texto){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(todasLinhasTabelaSeletor));
        driver.findElement(searchInputSeletor).sendKeys(texto);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(mensagemShowingSeletor, "filtered"));
    }

    public int getQuantidadeLinhasTabela() {
        return driver.findElements(linhasCorpoTabelaSeletor).size();
    }
}
