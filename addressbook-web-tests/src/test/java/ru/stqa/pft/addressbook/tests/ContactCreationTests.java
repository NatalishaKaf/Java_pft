package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void CreationTestContacts() {
        List<ContactObjects> before = app.contact().list();
        ContactObjects contact = new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                "address", "sdfsdf12355", null, "test1");
        app.contact().createContact(contact);
        List<ContactObjects> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);


        //int max = 0;
        /*for (ContactObjects g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }*/
        //Comparator<? super ContactObjects> ById= (Comparator<ContactObjects>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        //int max1= after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactObjects> byId= (b1, b2) -> Integer.compare(b1.getId(), b2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);


    }
}

