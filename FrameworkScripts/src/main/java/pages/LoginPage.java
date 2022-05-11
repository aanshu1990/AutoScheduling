package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  By email = By.xpath("//input[@id='email']");
  By password = By.xpath("//input[@id='password']");
  By clickSignIn = By.xpath("//div[contains(@class,'form-group button-holder')]//button");
  By settings = By.xpath("//div[contains(@class,'hl_nav-settings')]//span[text()=' Settings ']");
  By MyStaff = By.xpath("//div[contains(@class,'nav-header-without-footer')]//span[text()=' My Staff ']");
  By AddEmployee = By.xpath("//button[contains(@class,'items-center') and text()=' Add Employee ']");
  By UserInfo = By.xpath("//span[contains(@class,'header-wrap') and text()=' User Info ']");
  By FirstName = By.xpath("//span[contains(@class,'text-input-label block') and text()='First Name']/../..//input");
  By LastName = By.xpath("//span[contains(@class,'text-input-label block') and text()='Last Name']/../..//input");
  By EmailID = By.xpath("//span[contains(@class,'text-input-label block') and text()='Email']/../..//input");
  By PhoneNo = By.xpath("//input[@placeholder='Phone']");
  By userPassword = By.xpath("//span[text()='Password']/../..//input[@name='password']");
  By Save = By.xpath("(//button[contains(@class,'items-center') and text()=' Save '])[last()]");
  By Teams = By.xpath("//div[contains(@class,'topmenu-nav')]//span[text()=' Teams ']");
  By AddTeam = By.xpath("//button[contains(@class,'items-center') and text()=' Add Team ']");
  By TeamInfo = By.xpath("//span[contains(@class,'header-wrap') and text()=' Team Info ']");
  By AddTeamName = By.xpath("//div[contains(@class,'text-input-container')]//input[@name='team_name']");
  By AddTeamMembers = By.xpath("//label[text()=' Doctor 1 ']/../input");
  By SaveTeams = By.xpath("(//button[contains(@class,'font-medium rounded shadow-sm text') and text()=' Save '])[2]");

  // ***********************************************//

  public LoginPage login(String emailname, String pass) {
    driver.findElement(email).sendKeys(emailname);
    driver.findElement(password).sendKeys(pass);
    driver.findElement(clickSignIn).click();
    // driver.switchTo().alert().accept();

    return null;

  }

  public LoginPage createTeamMembers(String firstName, String lastName, String userEmail, String userPhone,
      String userPswd) throws InterruptedException {
    driver.findElement(settings).click();
    Thread.sleep(5000);
    driver.findElement(MyStaff).click();
    Thread.sleep(5000);
    driver.findElement(AddEmployee).click();
    driver.findElement(UserInfo).click();
    driver.findElement(FirstName).sendKeys(firstName);
    driver.findElement(LastName).sendKeys(lastName);
    driver.findElement(EmailID).sendKeys(userEmail);
    driver.findElement(PhoneNo).sendKeys(userPhone);
    driver.findElement(userPassword).sendKeys(userPswd);
    driver.findElement(Save).click();
    return null;
  }

  public LoginPage createTeams(String teamName, String doctorName) {
    String[] doctorNames = doctorName.split(";");

    driver.findElement(Teams).click();
    driver.findElement(AddTeam).click();
    driver.findElement(TeamInfo).click();
    driver.findElement(AddTeamName).sendKeys(teamName);
    for (String docName : doctorNames) {
      driver.findElement(By.xpath("//label[text()=' " + docName + " ']")).click();
    }

    clickUsingJs(SaveTeams);

    return null;
  }

}
