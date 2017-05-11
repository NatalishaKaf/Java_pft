package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

public class ContactCreationTests extends TestBase {

  @Test
  public void CreationTestContacts() {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
            "address", "sdfsdf12355", null, "test1"));
    int after= app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before+1);
  }
}

