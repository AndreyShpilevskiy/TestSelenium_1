import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


public class Selenium2Example {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the ismplementation.

        System.setProperty("webdriver.gecko.driver", "C://IT/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);

        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // driver.get("http://soft.it-hillel.com.ua:8080/secure/Dashboard.jspa");

        try {
            driver.findElement(By.id("login-form-username")).clear();
            WebElement element = driver.findElement(By.name("os_username"));
            element.sendKeys("andrej.shpilevskij");

            driver.findElement(By.id("login-form-password")).clear();
            WebElement element1 = driver.findElement(By.name("os_password"));
            element1.sendKeys("50650608");

            WebElement element2 = driver.findElement(By.id("login-form-submit"));
            element2.click();


            WebElement element3 = driver.findElement(By.id("create_link"));
            System.out.println("Page title is: " + element3);
            WebElement element4 = driver.findElement(By.id("quickSearchInput"));
            System.out.println("Page title is: " + element4);
            WebElement element5 = driver.findElement(By.xpath("//*[@id=\"dashboard-content\"]/div[1]/div/div[1]/h1"));
            System.out.println("Page title is: " + element5);



            driver.get("http://soft.it-hillel.com.ua:8080/browse/QAAUT-73");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.id("opsbar-operations_more")).click();
            driver.findElement(By.cssSelector("#create-subtask > span.trigger-label")).click();
            driver.findElement(By.id("summary")).clear();
            driver.findElement(By.id("summary")).sendKeys("test10 Andrey");
            driver.findElement(By.id("create-issue-submit")).click();


            driver.close();


        } catch (NoSuchElementException e) {
            fail("Element not found!!");
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}