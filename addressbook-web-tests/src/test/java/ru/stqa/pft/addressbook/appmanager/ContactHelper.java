package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;

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
        type(By.name("address"), contactObjects.getAddress());
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

    private void SelectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void modifyContacts(ContactObjects contact) {
        SelectContactById(contact.getId());
        initContactModificationById(contact.getId());
        fillFormContact(contact, false);
        submitContactModification();
        goToHome();
        initContactView();
        initContactModifiy();
        submitContactModification();
        contactCache = null;
        goToHome();
    }

    public void delete(ContactObjects contact) {
        SelectContactById(contact.getId());
        submitDeleteContact();
        contactCache = null;
        goToAlert();
        goToHome();

    }


    public void submitDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void goToAlert() {
        wd.switchTo().alert().accept();
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

    public void create(ContactObjects contact) {
        goToNewFormContact();
        //fillFormContact(new ContactObjects().withFirstname("name").withMiddlename("middlename").withLastname("lastname").withNickname("nick").
        // withCompany("company").withAddresss("address").withEmail("g@mail.ru"), true);
        fillFormContact(contact, true);
        SubmitContactCreation();
        contactCache = null;
        ReturnHomePage();
    }

    public void goToHome() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String[] phones = cells.get(5).getText().split("\n");
            String addresss = cells.get(3).getText();
            String email = cells.get(4).getText();
            //int id = Integer.parseInt(elements.get(0).findElement(By.cssSelector("input")).getAttribute("value"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //ContactObjects contact =
            contactCache.add(new ContactObjects().withId(id).withFirstname(firstname).withLastname(lastname).withPhones(phones)
                    .withAddress(addresss).withEmail(email));
        }

        return new Contacts(contactCache);
    }

    public ContactObjects infoFromEditForm(ContactObjects contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        wd.navigate().back();
        return new ContactObjects().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilPhone(mobile).withWorkPhone(work). withAddress(address).withEmail(email);

    }

    private void initContactModificationByIdA (int id) {
       wd.findElement(By.xpath(String.format("//input[@va;ue='%s']/../../td[8]/a", id)));

    }
   //*/ private void initContactModificationById(int id) {
      //  wd.findElement(By.xpath(String.format("//input[@va;ue='%s']/../../td[8]/a", id)));
        /*WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value= '%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
*/
    //}*/
}

