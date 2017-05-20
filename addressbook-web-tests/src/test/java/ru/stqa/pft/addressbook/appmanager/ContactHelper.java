package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToNewFormContact() {
        click(By.linkText("add new"));
    }

    public void fillFormContact(ContactObjects contactObjects, boolean creation) {
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



    public void SelectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
    public void modifyContacts(int index, ContactObjects contact) {
        SelectContact(index);
        initContactModification(index);
        fillFormContact(contact, false);
        submitContactModification();
        goToHome();
        initContactView();
        initContactModifiy();
        submitContactModification();
        goToHome();
    }
    public void delete(int index) {
        SelectContact(index);
        submitDeleteContact();
        goToAlert();
        goToHome();
    }


    public void submitDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void goToAlert() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[8]")).get(index).click();

        //div[@id='content']/form[1]/input[22]
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void initContactView() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
    }

    public void initContactModifiy() {
        click(By.name("modifiy"));
    }

    public void createContact(ContactObjects contact) {
        goToNewFormContact();
        fillFormContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                "address", "sdfsdf12355", null, "[none]"), true);
        SubmitContactCreation();
        ReturnHomePage();
    }
    public void goToHome() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }
    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public List<ContactObjects> list() {
        List<ContactObjects> contacts = new ArrayList<ContactObjects>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            //int id = Integer.parseInt(elements.get(0).findElement(By.cssSelector("input")).getAttribute("value"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactObjects contact = new ContactObjects(id, firstname, null, lastname, null, null, null, null,
                    null, null, null);
            contacts.add(contact);
        }

        return contacts;

    }
}

