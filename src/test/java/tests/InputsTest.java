package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputsTest {

    private ChromeDriver driver;

    private final String LINK_APP = "http://the-internet.herokuapp.com/inputs";
    private final String INPUT = "input";


    @BeforeClass
    public void preconditions(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.get(LINK_APP);
    }

    @Test
    public void verifyAbilityInputNumbersTest(){
        driver.findElement(By.tagName(INPUT)).click();
        driver.findElement(By.tagName(INPUT)).sendKeys(Keys.ARROW_UP);
        String enteredNumbers = driver.findElement(By.tagName(INPUT)).getAttribute("value");
        Assert.assertEquals(enteredNumbers, "1");

    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
