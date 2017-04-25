package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase{

  @Test
  public void testGroupDeletionTests () {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().SelectGroup();
    app.getGroupHelper().DeleteSelectGroups();
    app.getGroupHelper().returnGroupPage();
  }

}