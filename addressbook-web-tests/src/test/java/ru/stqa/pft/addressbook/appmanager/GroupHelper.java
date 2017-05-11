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

  public void DeleteSelectGroups() {
    click(By.name("delete"));
  }

  public void SelectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void initvCard() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[9]/a/img"));
  }

  public void createGroup(GroupObjects group) {
      initGroupCreation();
      fillGroupForm(group);
      submitGroupCreation();
      returnGroupPage();
    }

    public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
    }
}
