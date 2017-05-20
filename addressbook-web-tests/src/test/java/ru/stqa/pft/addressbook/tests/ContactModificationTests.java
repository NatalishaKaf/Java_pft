package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.*;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().FormContacts();
        if (app.contact().list().size() == 0) {
            app.contact().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                    "address", "sdfsdf12355", null, "test1"));
        }
    }

    @Test
    public void testContactModification() {
        List<ContactObjects> before = app.contact().list();
        int index= before.size() - 1;
        ContactObjects contact = new ContactObjects(before.get(index).getId(), "Наталья", "ДНВ", "Долгополова", "Natalisha",
                "Tester", "1C", "Moscow", "Korolev", "natalya-strel@yandex.ru", null);
        app.contact().modifyContacts(index, contact);
        List<ContactObjects> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactObjects> byId= (b1, b2) -> Integer.compare(b1.getId(), b2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }



}
