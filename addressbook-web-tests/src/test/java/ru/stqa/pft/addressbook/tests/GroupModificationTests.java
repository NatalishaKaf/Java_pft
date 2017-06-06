package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size()==0){
        app.goTo().groupPage();
        //if (!app.group().isThereAGroup()) {
            app.group().create(new GroupObjects().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupObjects modifiedGroup = before.iterator().next();
       // int index = before.size()-1;
        GroupObjects group = new GroupObjects().withId(modifiedGroup.getId()).withName("GroupName").
                withHeader("GroupHeader").withFooter("GroupFooter");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        //before.remove(modifiedGroup);
        //before.add(group);
       /* Comparator<? super GroupObjects> ById= (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);*/
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));


    }


    }



