package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupObjects("test1",null, null));
        }
        app.getGroupHelper().SelectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupObjects("GroupName", "GroupHeader", "GroupFooter"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupPage();
        int after= app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);

    }

}
