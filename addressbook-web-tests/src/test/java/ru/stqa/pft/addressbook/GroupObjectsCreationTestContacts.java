package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupObjectsCreationTestContacts extends TestBase {

  @Test
  public void GroupObjectsCreationTestContacts() {
    goToNewFormContact();
    fillFormContact("fgdfg", "xfdgfg", "xcv", "dfg", "dxfbcdvb", "cvbvcb", "address", "sdfsdf12355", "");
    SubmitContactCreation();
    ReturnHomePage();
  }
}


