package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line=  reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new GroupObjects().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }


        /*list.add(new Object[]{new GroupObjects().withName("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[]{new GroupObjects().withName("test2").withHeader("header2").withFooter("footer2")});
        list.add(new Object[]{new GroupObjects().withName("test3").withHeader("header3").withFooter("footer3")});*/

    @Test (dataProvider = "validGroups")
    public void testGroupCreation(GroupObjects group) {
        /*String[] names = new String[] {"test1", "test2", "test3"};
        for (String name: names) {*/
            //GroupObjects group = new GroupObjects().withName(name).withHeader(header).withFooter(footer);
            app.goTo().groupPage();
            Groups before = app.group().all();
           // GroupObjects group = new GroupObjects().withName("test1");
            app.group().create(group);
            assertThat(app.group().count(), equalTo(before.size() + 1));
            Groups after = app.group().all();
            assertThat(after, equalTo
                    (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        }


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


    @Test (enabled = false)
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
