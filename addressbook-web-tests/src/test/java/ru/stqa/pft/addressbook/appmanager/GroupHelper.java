package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.GroupObjects;

public class GroupHelper extends HelperBase {


  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupObjects groupObjects) {
    type(By.name("group_name"), groupObjects.getName());
    type(By.name("group_header"), groupObjects.getHeader());
    type(By.name("group_footer"), groupObjects.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void ReturnHomePage() {
    click(By.xpath("//div/div[4]/div/i/a[2]"));
  }

  public void SubmitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
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
      //if (isElementPresent(By.name("new_group"))) {
        //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactObjects.getGroup());
      }
    }

  public void goToNewFormContact() {
    click(By.linkText("add new"));
  }

  public void DeleteSelectGroups() {
    click(By.name("delete"));
  }

  public void SelectGroup() {
    click(By.name("selected[]"));
  }


  public void goToAlert() {
    wd.switchTo().alert().accept();
  }

  public void submitDeleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void goToFormContacts() {
    click(By.linkText("home"));
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
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

  public void initvCard() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[9]/a/img"));
  }

    public void createGroup(GroupObjects group) {
      initGroupCreation();
      fillGroupForm(new GroupObjects("test1",null, null));
      submitGroupCreation();
      returnGroupPage();
    }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }
}
