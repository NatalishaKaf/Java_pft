package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupObjectsCreationTestContacts extends TestBase {

  @Test
  public void GroupObjectsCreationTestContacts() {
    app.goToNewFormContact();
    app.fillFormContact("fgdfg", "xfdgfg", "xcv", "dfg", "dxfbcdvb", "cvbvcb", "address", "sdfsdf12355", "");
    app.SubmitContactCreation();
    app.ReturnHomePage();
  }
}


