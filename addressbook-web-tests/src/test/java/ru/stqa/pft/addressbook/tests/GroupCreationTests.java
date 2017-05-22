package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupObjects group = new GroupObjects().withName("test1");
        app.group().create(group);
        assertThat(app.group().count(),equalTo( before.size()+1));
        Groups after = app.group().all();
        // int max= 0;
        //for(GroupObjects g:after) {
        // if (g.getId() > max) {
        // max = g.getId();
        //}
        //}
        //Comparator<? super GroupObjects> byId= (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        //  int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
       // before.add(group);
        /*Comparator<? super GroupObjects> ById= (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);*/
        assertThat(after, equalTo
                (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupObjects group = new GroupObjects().withName("test1'");
        app.group().create(group);
        assertThat(app.group().count(),equalTo( before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
                //(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
