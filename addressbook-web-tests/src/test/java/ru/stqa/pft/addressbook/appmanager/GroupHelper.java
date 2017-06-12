package ru.stqa.pft.addressbook.appmanager;


import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

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


    public void SelectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void modify(GroupObjects group) {
        SelectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnGroupPage();
    }

    public void delete(GroupObjects group) {
        SelectGroupById(group.getId());
        DeleteSelectGroups();
        groupCache = null;
        returnGroupPage();
    }

    /*public void deleteContactFromGroup(GroupObjects groups){

        new Select(wd.findElement(By.name("group"))).selectByValue(groups.getName());

    }
*/
    public void create(GroupObjects group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }
        private Groups groupCache = null;
        public Groups all() {
            if (groupCache != null) {
                return new Groups (groupCache);
            }
            groupCache = new Groups();
            List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
            for (WebElement element : elements) {
                String name = element.getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                // GroupObjects group = ;
                groupCache.add(new GroupObjects().withId(id).withName(name));
            }
            return new Groups(groupCache);

    }


}

  /*  public void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }*/
