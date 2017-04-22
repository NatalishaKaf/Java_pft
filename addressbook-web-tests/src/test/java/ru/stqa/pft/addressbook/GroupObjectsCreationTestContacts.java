package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupObjectsCreationTestContacts {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    login();
  }

  private void login() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void GroupObjectsCreationTestContacts() {
    formContacts();
    goToNewFormContact();
    fillFormContact();
    SubmitContactCreation();
    ReturnHomePage();
  }

  private void ReturnHomePage() {
    wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
  }

  private void SubmitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillFormContact() {
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("fgdfg");
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys("xfdgfg");
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("xcv");
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys("dfg");
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys("dxfbcdvb");
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys("cvbvcb");
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys("dxfbgdfbg35646546");
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys("sdfsdf12355");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("adefadf354");

  }

  private void goToNewFormContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void formContacts() {
    new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("strong"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.id("maintable"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.linkText("Last name"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("th.sortable.fd-column-1"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.linkText("First name"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("th.sortable.fd-column-2"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.linkText("First name"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("th.sortable.fd-column-2"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.id("nav"))).build().perform();
    new Actions(wd).moveToElement(wd.findElement(By.linkText("add new"))).build().perform();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
