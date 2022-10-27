package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class CheckboxesTest {
    private final String CHECKBOX_SELECTOR = "[type=checkbox]";

    private ChromeDriver driver;

    @BeforeClass
    public void preconditions(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        chromeOptions.addArguments("--incognito");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();
    }

    @Test
    public void verifyFirstCheckboxUncheckedTest(){
        boolean isSelectedCheckbox = driver.findElements(By.cssSelector(CHECKBOX_SELECTOR)).get(0).isSelected();
        Assert.assertFalse(isSelectedCheckbox, "Check box not selected");
    }

    @Test
    public void verifyFirstCheckboxCheckedTest(){
        driver.findElements(By.cssSelector(CHECKBOX_SELECTOR)).get(0).click();
        boolean isSelectedCheckbox = driver.findElements(By.cssSelector(CHECKBOX_SELECTOR)).get(0).isSelected();
        Assert.assertTrue(isSelectedCheckbox, "Checkbox selected");
    }

    @Test
    public void verifySecondCheckboxCheckedTest(){
        driver.findElements(By.cssSelector(CHECKBOX_SELECTOR)).get(1).click();
        boolean isSelectedCheckbox = driver.findElements(By.cssSelector(CHECKBOX_SELECTOR)).get(1).isSelected();
        Assert.assertFalse(isSelectedCheckbox, "Checkbox not selected");

    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
