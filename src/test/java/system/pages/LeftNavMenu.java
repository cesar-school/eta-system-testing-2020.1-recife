package system.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import system.helpers.DriverManager;

public class LeftNavMenu {

    /*
     Representação
     */

    private WebDriver driver;
    private WebDriverWait wait;

    // Nav Menu
    private By navMenuSeletor = By.cssSelector("#navbar-brand-centered");
    private By inputFormsBotaoSeletor = By.cssSelector(".nav > li:nth-child(1)");
    private By datePickerBotaoSeletor = By.cssSelector(".nav > li:nth-child(2)");
    private By tableBotaoSeletor = By.cssSelector(".nav > li:nth-child(3)");

    // Table sub menu
    private By tableSortSearchBotaoSeletor = By.cssSelector(".dropdown-menu > li:nth-child(4)");
    private By tablePaginationSeletor = By.cssSelector(".dropdown-menu > li:nth-child(1)");

    /*
     Serviços
     */

    public LeftNavMenu() {
        this.driver = DriverManager.getDriver();
        this.wait = DriverManager.getDriverWait();
    }

//    public TableSortSearchPage navegarParaTableSortSearch() {
//        this.clicarBotaoSubMenu(tableBotaoSeletor, tableSortSearchBotaoSeletor);
//        return new TableSortSearchPage();
//    }

    public void navegarParaTableSortSearch() {
        this.clicarBotaoSubMenu(tableBotaoSeletor, tableSortSearchBotaoSeletor);
    }

    public void navegarParaTablePagination() {
        this.clicarBotaoSubMenu(tableBotaoSeletor, tablePaginationSeletor);
    }

    private void clicarBotaoSubMenu(By botaoMenuSeletor, By submenuSeletor) {
        WebElement navMenu = driver.findElement(navMenuSeletor);
        WebElement botaoMenu = navMenu.findElement(botaoMenuSeletor);
        botaoMenu.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(submenuSeletor));
        WebElement submenu = botaoMenu.findElement(submenuSeletor);
        submenu.click();
    }
}
