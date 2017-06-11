package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupObjects().withName("test1"));
        }
    }

    @Test
        public void testGropDeletions(){
        Groups before = app.db().groups();
        GroupObjects deletedGroup = before.iterator().next();
       // int index= before.size() - 1;
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(),equalTo( before.size()-1));
        Groups after = app.db().groups();
        //before.remove(deletedGroup);
        assertThat(after, equalTo(before.withOut(deletedGroup)));
        //Assert.assertEquals(before, after);

    }

}