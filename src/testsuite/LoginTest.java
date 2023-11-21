package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseurl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginWithValidCredentials() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        // Find the password field and Type the password to password field
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        // Find the login button element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedMessage = "Dashboard";
        String actualMessage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("User was unable to login successfully.", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
