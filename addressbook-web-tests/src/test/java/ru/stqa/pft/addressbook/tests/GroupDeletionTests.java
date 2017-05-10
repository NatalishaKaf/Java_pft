package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;


public class GroupDeletionTests extends TestBase{

  @Test
  public void testGroupDeletionTests () {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupObjects("test1",null, null));
    }
    app.getGroupHelper().SelectGroup();
    app.getGroupHelper().DeleteSelectGroups();
    app.getGroupHelper().returnGroupPage();
  }

}