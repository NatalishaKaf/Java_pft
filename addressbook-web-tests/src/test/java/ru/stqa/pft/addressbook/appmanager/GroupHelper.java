package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupObjects;

public class GroupHelper extends HelperBase {


  public GroupHelper(FirefoxDriver wd) {
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

  public void fillFormContact(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String email) {
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(firstname);
    type(By.name("middlename"), middlename);
    type(By.name("lastname"), lastname);
    type(By.name("nickname"), nickname);
    type(By.name("title"), title);
    type(By.name("company"), company);
    type(By.name("address"), address);
    type(By.name("home"), home);
    type(By.name("email"), email);

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

  public void goToHome() {

    click(By.linkText("home"));
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
}
