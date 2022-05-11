package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
  final WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void clickUsingJs(By locator) {
    WebElement element = driver.findElement(locator);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    executor.executeScript("arguments[0].click();", element);
  }

  public void clickByAction(By locator) {
    Actions action = new Actions(driver);
    WebElement element = driver.findElement(locator);
    action.moveToElement(element).click().perform();
  }

}
