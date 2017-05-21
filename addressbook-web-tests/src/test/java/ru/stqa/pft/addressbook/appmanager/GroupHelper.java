package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.ArrayList;
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

    public void modify(int index, GroupObjects group) {
        SelectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returnGroupPage();
    }
    public void delete(int index) {
        SelectGroup(index);
        DeleteSelectGroups();
        returnGroupPage();
    }

    public void create(GroupObjects group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnGroupPage();
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupObjects> list() {
        List<GroupObjects> groups = new ArrayList<GroupObjects>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
           // GroupObjects group = ;
            groups.add(new GroupObjects().withId(id).withName(name));
        }
        return groups;

    }
}
