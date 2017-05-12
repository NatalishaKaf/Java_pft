package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.List;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupObjects> before = app.getGroupHelper().getGroupList();
    GroupObjects group= new GroupObjects("test1",null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupObjects> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);


    int max= 0;
    for(GroupObjects g:after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId (max);
    before.add(group);
    Assert.assertEquals(after.size(),before.size());
    }

  }
