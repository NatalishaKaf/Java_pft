package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void GroupObjectsCreationTestContacts() {
    app.getGroupHelper().goToNewFormContact();
    app.getGroupHelper().fillFormContact("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb", "address", "sdfsdf12355", null);
    app.getGroupHelper().SubmitContactCreation();
    app.getGroupHelper().ReturnHomePage();
  }
}

