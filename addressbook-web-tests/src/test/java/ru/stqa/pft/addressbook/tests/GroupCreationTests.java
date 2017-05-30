package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
        String json = "";
        String line =  reader.readLine();
        while (json != null) {
          json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GroupObjects> groups = gson.fromJson(json, new TypeToken<List<GroupObjects>>(){}.getType()); //List<GroupObjects>.class
        return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }


        /*list.add(new Object[]{new GroupObjects().withName("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[]{new GroupObjects().withName("test2").withHeader("header2").withFooter("footer2")});
        list.add(new Object[]{new GroupObjects().withName("test3").withHeader("header3").withFooter("footer3")});*/

    @Test (dataProvider = "validGroupsFromJson")
    public void testGroupCreation(GroupObjects group) {
            app.goTo().groupPage();
            Groups before = app.group().all();
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
