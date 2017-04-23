package ru.stqa.pft.addressbook;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

  @BeforeMethod
  public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/group.php");
    Login("admin", "secret");
  }

  private void Login(String username, String password) {wd.findElement(By.name("user")).click();
  wd.findElement(By.name("user")).clear();
  wd.findElement(By.name("user")).sendKeys(username);
  wd.findElement(By.name("pass")).click();
  wd.findElement(By.name("pass")).clear();
  wd.findElement(By.name("pass")).sendKeys(password);
  wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
}

  protected void returnGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  protected void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupObjects groupObjects) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupObjects.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupObjects.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupObjects.getFooter());
  }

  protected void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  protected void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod
    public void tearDown() {
        wd.quit();
    }

  protected void DeleteSelectGroups() {
      wd.findElement(By.name("delete")).click();
  }

  protected void SelectGroup() {
      wd.findElement(By.name("selected[]")).click();
  }
}
