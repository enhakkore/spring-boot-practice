package readinglist;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerWebTests {
    private static FirefoxDriver browser;

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "/home/chihyun/src/geckodriver");

        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }

    @Test
    public void addBookToList(){
        String baseUrl = "http://localhost:" + port;

        browser.get(baseUrl);

        browser.findElementByName("username").sendKeys("craig");
        browser.findElementByName("password").sendKeys("password");
        browser.findElementByXPath(".//input[@value='Login']").click();

        Assert.assertEquals("You have no books in your book list", browser.findElementByTagName("div").getText());

        browser.findElementByName("title").sendKeys("Book Title");
        browser.findElementByName("author").sendKeys("Book Author");
        browser.findElementByName("isbn").sendKeys("12341234");
        browser.findElementByName("description").sendKeys("Description");
        browser.findElementByXPath(".//input[@value='Add Book']").click();

        WebElement dl = browser.findElementByCssSelector("dt.bookHeadline");
        Assert.assertEquals("Book Title by Book Author (ISBN: 12341234)", dl.getText());

        WebElement dt = browser.findElementByCssSelector("dd.bookDescription");
        Assert.assertEquals("Description", dt.getText());
    }
}
