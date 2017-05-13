package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupObjects> before = app.getGroupHelper().getGroupList();
    GroupObjects group= new GroupObjects("test8",null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupObjects> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);


   // int max= 0;
    //for(GroupObjects g:after) {
     // if (g.getId() > max) {
       // max = g.getId();
      //}
    //}
    //Comparator<? super GroupObjects> byId= (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
  //  int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    group.setId (after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals (new HashSet<Object>(before), new HashSet<Object>(after));
    }

  }
