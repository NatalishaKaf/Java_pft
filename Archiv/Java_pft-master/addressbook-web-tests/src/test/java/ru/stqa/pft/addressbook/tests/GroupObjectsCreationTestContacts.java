package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupObjectsCreationTestContacts extends TestBase {

  @Test
  public void GroupObjectsCreationTestContacts() {
    app.getGroupHelper().goToNewFormContact();
    app.getGroupHelper().fillFormContact("fgdfg", "xfdgfg", "xcv", "dfg", "dxfbcdvb", "cvbvcb", "address", "sdfsdf12355", "");
    app.getGroupHelper().SubmitContactCreation();
    app.getGroupHelper().ReturnHomePage();
  }
}

