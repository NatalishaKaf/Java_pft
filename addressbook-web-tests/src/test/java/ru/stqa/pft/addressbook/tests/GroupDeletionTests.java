package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase{

    @Test
    public void testGroupDeletionTests () {
       app.goToGroupPage();
       app.SelectGroup();
       app.DeleteSelectGroups();
       app.returnGroupPage();
    }


}