package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    // set up browser
    @Before
    public void browserSetUp() {
        openBrowser(baseUrl);
    }

    @Test
    // userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("Not right!", expectedText, actualText);
    }

    @Test
    // verifyTheUsernameErrorMessage
    public void verifyTheUsernameErrorMessage() {
        // Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the error message “Your username is invalid!”
        String expectedText = "Your username is Invalid!";
        String newText = driver.findElement(By.xpath("/html/body/div[1]/div[1]/text()")).getText();
        //Assert.assertEquals("Can't Login", expectedText, actualText);
        System.out.println("newText");
    }

    @Test
    // verifyThePasswordErrorMessage
    public void verifyThePasswordErrorMessage() {

        // Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify the error message “Your password is invalid!”
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.xpath("//div[@id=flash]/text()")).getText();
        Assert.assertEquals("Wrong Password", expectedText, actualText);

    }

    // close the browser
    public void tearDown() {
        closeBrowser();
    }
}