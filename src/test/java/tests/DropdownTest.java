package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest {
    private ChromeDriver driver;

    private final String DROPDOWN_LOCATOR = "dropdown";
    private final String FIRST_OPTION = "Option 1";
    private final String SECOND_OPTION = "Option 2";

    @BeforeClass
    public void preconditions(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void verifyFirstDropdownOptionIsDisplayedTest(){
       Select select = new Select(driver.findElement(By.id(DROPDOWN_LOCATOR)));
       select.selectByVisibleText(FIRST_OPTION);
       String selectedOption = select.getFirstSelectedOption().getText();
       Assert.assertEquals(selectedOption, FIRST_OPTION, "Option is displayed correctly");
    }

    @Test
    public void verifySecondDropdownOptionIsDisplayedTest(){
        Select select = new Select(driver.findElement(By.id(DROPDOWN_LOCATOR)));
        select.selectByVisibleText(SECOND_OPTION);
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, SECOND_OPTION, "All is okay");
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }

}
