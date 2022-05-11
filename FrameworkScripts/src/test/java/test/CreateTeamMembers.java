package test;

import org.openqa.selenium.WebDriver;

import dataProvider.AutoVariables;
import pages.LoginPage;

public class CreateTeamMembers {

  public static void main(String args[]) throws InterruptedException {

    // Launch Browser
    BaseTest basetest = new BaseTest();
    WebDriver driver = basetest.launchBrowser();

    // Login to Application
    LoginPage login = new LoginPage(driver);
    login.login(AutoVariables.emailId, AutoVariables.Pass);
    Thread.sleep(10000);
    // Create Team Members
    login.createTeamMembers(AutoVariables.firstName, AutoVariables.lastName, AutoVariables.userEmail,
        AutoVariables.userPhone, AutoVariables.userPswd);
    // Create Teams
    Thread.sleep(10000);
    login.createTeams(AutoVariables.teamName, AutoVariables.docName);
    driver.close();

  }

}
