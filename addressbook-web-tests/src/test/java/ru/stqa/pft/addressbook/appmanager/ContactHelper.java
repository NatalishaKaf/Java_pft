package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void goToNewFormContact() {
        click(By.linkText("add new"));
    }
    public void fillFormContact(ContactObjects contactObjects,boolean creation) {
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactObjects.getFirstname());
        type(By.name("middlename"), contactObjects.getMiddlename());
        type(By.name("lastname"), contactObjects.getLastname());
        type(By.name("nickname"), contactObjects.getNickname());
        type(By.name("title"), contactObjects.getTitle());
        type(By.name("company"), contactObjects.getCompany());
        type(By.name("address"), contactObjects.getAddresss());
        type(By.name("home"), contactObjects.getHome());
        type(By.name("email"), contactObjects.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactObjects.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }
    public void SubmitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
    public void ReturnHomePage() {
        click(By.xpath("//div/div[4]/div/i/a[2]"));
    }

    public void goToFormContacts() {
        click(By.linkText("home"));
    }
    public void SelectContact(int index){
        wd.findElements(By.name("selected[]")).get(index).click();
    }
    public void submitDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }
    public void goToAlert() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

        //div[@id='content']/form[1]/input[22]
    }
    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void initContactView (){
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
    }

    public void initContactModifiy() {
        click(By.name("modifiy"));
    }

    public void createContact(ContactObjects contact){
        goToNewFormContact();
        fillFormContact(new ContactObjects(null, "fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                "address", "sdfsdf12355", null, "test1"),true);
        SubmitContactCreation();
        ReturnHomePage();
    }
    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }



    public List<ContactObjects> getContactList() {
        List<ContactObjects> contacts = new ArrayList<ContactObjects>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            String firstname = element.getText();
            String lastname = element.getText();
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int index;
            String id= element.findElements(By.cssSelector("table tr td")).get(index).click();
        ContactObjects contact = new ContactObjects(id, firstname,null, lastname, null,null,null,null,
        null, null,null);
        contacts.add(contact);
        }

        return contacts;

    }
}

