package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.List;


public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupObjects("test1", null, null));
        }
    }

    @Test
        public void testGropDeletions(){
        List<GroupObjects> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().SelectGroup(before.size() - 1);
        app.getGroupHelper().DeleteSelectGroups();
        app.getGroupHelper().returnGroupPage();
        List<GroupObjects> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);


    }

}