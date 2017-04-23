package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupObjects;

public class GroupCreationTests extends TestBase{

  @Test
    public void testGroupCreation() {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupObjects("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnGroupPage();
  }

    }

