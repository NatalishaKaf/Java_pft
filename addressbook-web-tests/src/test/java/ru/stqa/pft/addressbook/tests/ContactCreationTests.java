package ru.stqa.pft.addressbook.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void CreationTestContacts() {
    List<ContactObjects> before = app.getContactHelper().getContactList();
    ContactObjects contact =new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
            "address", "sdfsdf12355", null, "test1");
    app.getContactHelper().createContact(contact);
    List<ContactObjects> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);


    int max = 0;
    for (ContactObjects g : after){
      if (g.getId()> max){
        max= g.getId();
      }
    }
    //Comparator<? super ContactObjects> ById= (Comparator<ContactObjects>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    //int max1= after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals (new HashSet<Object>(before), new HashSet<Object>(after));


  }
}

