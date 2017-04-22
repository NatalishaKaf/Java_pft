package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class GroupObjectsCreationTestContacts {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys("\\undefined");
        new Actions(wd).moveToElement(wd.findElement(By.id("LoginForm"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("user"))).build().perform();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        new Actions(wd).moveToElement(wd.findElement(By.id("LoginForm"))).build().perform();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("LoginForm"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@id='LoginForm']//label[.='Password:']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("LoginForm"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]"))).build().perform();
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }
    
    @Test
    public void GroupObjectsCreationTestContacts() {
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
        wd.findElement(By.linkText("add new")).click();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("add new"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("nav"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("firstname"))).build().perform();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("fgdfg");
        new Actions(wd).moveToElement(wd.findElement(By.name("middlename"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("middlename"))).build().perform();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).sendKeys("\\undefined");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys("xfdgfg");
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("lastname"))).build().perform();
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).sendKeys("\\undefined");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("xcv");
        new Actions(wd).moveToElement(wd.findElement(By.name("nickname"))).build().perform();
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys("dfg");
        new Actions(wd).moveToElement(wd.findElement(By.name("photo"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("title"))).build().perform();
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).sendKeys("\\undefined");
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys("dxfbcdvb");
        new Actions(wd).moveToElement(wd.findElement(By.name("company"))).build().perform();
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys("cvbvcb");
        new Actions(wd).moveToElement(wd.findElement(By.name("address"))).build().perform();
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("dxfbgdfbg35646546");
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys("sdfsdf12355");
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("homepage"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("email2"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("email"))).build().perform();
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).sendKeys("\\undefined");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("adefadf354");
        new Actions(wd).moveToElement(wd.findElement(By.name("email2"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("email3"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("theform"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("notes"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']/form/input[21]"))).build().perform();
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).sendKeys("\\undefined");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("html"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("v8.2.5"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("container"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.msgbox"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("home page"))).build().perform();
        wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("home"))).build().perform();
        wd.findElement(By.linkText("home")).click();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("home"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("nav"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("html"))).build().perform();
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
