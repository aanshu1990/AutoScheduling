package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

  public WebDriver launchBrowser() {
    // set path to chrome driver.exe
    System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkspace_New\\FrameworkScripts\\chromedriver.exe");
    // ChromeOptions object
    ChromeOptions op = new ChromeOptions();
    // disable notification parameter
    op.addArguments("--disable-notifications");
    // Launch Browser
    WebDriver driver = new ChromeDriver(op);
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    driver.get("http://app.gohighlevel.com");
    driver.manage().window().maximize();
    // Print title of the page
    System.out.println(driver.getTitle());

    return driver;
  }

}
