package system;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import system.helpers.DriverManager;
import java.util.List;

public class Main {

    private WebDriver driver;

    @Test
    void atividade00() throws InterruptedException{
        driver = DriverManager.getDriver();
        driver.get("https://www.cesar.school");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(2000);
        DriverManager.endSession();
        System.out.println("quero imprimir");
    }

//    public static void main(String [] args){
//
//        WebDriver driver = DriverManager.getDriver();
//
//        driver.get("https://www.cesar.school");
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.cesar.school/graduacao");
//        driver.navigate().back();
//        driver.navigate().refresh();
//
//        DriverManager.endSession();
//    }
}
