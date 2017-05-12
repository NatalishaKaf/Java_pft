package ru.stqa.pft.addressbook.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void CreationTestContacts() {
    List<ContactObjects> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
            "address", "sdfsdf12355", null, "test1"));
    List<ContactObjects> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
  }
}

