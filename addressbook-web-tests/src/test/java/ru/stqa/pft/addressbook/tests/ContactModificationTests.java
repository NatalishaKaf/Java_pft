package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test

    public void testContactModification () {
        app.getContactHelper().goToFormContacts();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                    "address", "sdfsdf12355", null, "test1"));
        }
        List<ContactObjects> before = app.getContactHelper().getContactList();
        app.getContactHelper().SelectContact(before.size()-1);
        app.getContactHelper().initContactModification();
        ContactObjects contact= new ContactObjects(before.get(before.size()-1).getId(),"Наталья", "ДНВ", "Долгополова", "Natalisha",
                "Tester", "1C", "Moscow", "Korolev", "natalya-strel@yandex.ru", null);
        app.getContactHelper().fillFormContact(contact,false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
        app.getContactHelper().initContactView();
        app.getContactHelper().initContactModifiy();
       // testContactModification ()
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
        List<ContactObjects>after= app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

       before.remove(before.size()-1);
       before.add (contact);
       Assert.assertEquals (new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
