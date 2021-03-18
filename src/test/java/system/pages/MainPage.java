package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;
import static system.pages.URL.MAIN_PAGE;

public class MainPage {

    /*
     Representação
     */

    private WebDriver driver;
    private WebDriverWait wait;
    private By nomeDoSite = By.cssSelector("#site-name");
    private By learnSeleniumAdd = By.cssSelector(".at-cm-no-button");

    /*
     Serviços
     */

    public MainPage() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getDriverWait();
    }

    public void acessarPagina(){
        driver.get(MAIN_PAGE);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(learnSeleniumAdd));
            driver.findElement(learnSeleniumAdd).click();
        } catch (Exception e) {
            // Vamos fazer nada aqui
        }
    }

    public String getNomeDoSite(){
        return driver.findElement(nomeDoSite).getText();
    }

    public LeftNavMenu getLeftNavMenu() {
        return new LeftNavMenu();
    }

}
