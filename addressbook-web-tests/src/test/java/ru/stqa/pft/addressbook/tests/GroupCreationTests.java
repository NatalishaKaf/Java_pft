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
    app.getGroupHelper().createGroup(new GroupObjects("test1",null, null));
    List<GroupObjects> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(),before.size()+1);

  }

}
