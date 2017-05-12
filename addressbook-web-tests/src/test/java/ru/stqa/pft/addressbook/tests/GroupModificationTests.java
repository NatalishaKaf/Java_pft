package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupObjects("test1",null, null));
        }
        List<GroupObjects> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().SelectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupObjects group= new GroupObjects(before.get(before.size()-1).getId(),"GroupName",
                "GroupHeader", "GroupFooter");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupPage();
        List<GroupObjects> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add (group);
        Assert.assertEquals (new HashSet<Object>(before), new HashSet<Object>(after));


    }

}
