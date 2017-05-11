package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;


public class GroupDeletionTests extends TestBase{

  @Test
  public void testGroupDeletionTests () {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupObjects("test1",null, null));
    }
    app.getGroupHelper().SelectGroup(before-1);
    app.getGroupHelper().DeleteSelectGroups();
    app.getGroupHelper().returnGroupPage();
    int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before-1);

  }

}