package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        //if (!app.group().isThereAGroup()) {
        if (app.group().list().size() == 0) {
            app.group().create(new GroupObjects("test1", null, null));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupObjects> before = app.group().list();
        int index = before.size()-1;
        GroupObjects group = new GroupObjects(before.get(index).getId(), "GroupName",
                "GroupHeader", "GroupFooter");
        app.group().modify(index, group);
        List<GroupObjects> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupObjects> ById= (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);


    }


    }



