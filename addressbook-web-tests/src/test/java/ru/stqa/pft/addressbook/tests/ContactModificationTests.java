package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.*;

public class ContactModificationTests extends TestBase {
    @Test

    public void testContactModification() {
        app.getContactHelper().goToFormContacts();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                    "address", "sdfsdf12355", null, "test1"));
        }
        List<ContactObjects> before = app.getContactHelper().getContactList();
        app.getContactHelper().SelectContact(before.size() - 1);
        app.getContactHelper().initContactModification(before.size() - 1);
        ContactObjects contact = new ContactObjects(before.get(before.size() - 1).getId(), "Наталья", "ДНВ", "Долгополова", "Natalisha",
                "Tester", "1C", "Moscow", "Korolev", "natalya-strel@yandex.ru", null);
        app.getContactHelper().fillFormContact(contact, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
        app.getContactHelper().initContactView();
        app.getContactHelper().initContactModifiy();
        // testContactModification ()
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
        List<ContactObjects> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactObjects> byId= (b1, b2) -> Integer.compare(b1.getId(), b2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }

}
