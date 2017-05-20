package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupObjects> before = app.group().list();
        GroupObjects group = new GroupObjects("test8", null, null);
        app.group().create(group);
        List<GroupObjects> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);


        // int max= 0;
        //for(GroupObjects g:after) {
        // if (g.getId() > max) {
        // max = g.getId();
        //}
        //}
        //Comparator<? super GroupObjects> byId= (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        //  int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Comparator<? super GroupObjects> ById= (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);
    }

}
