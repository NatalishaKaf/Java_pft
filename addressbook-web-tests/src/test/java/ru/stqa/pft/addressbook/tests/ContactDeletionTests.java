package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.List;

public class ContactDeletionTests extends TestBase {


    @Test
    public void GroupDeletionContacts() {
        app.getContactHelper().goToFormContacts();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                    "address", "sdfsdf12355", null, "test1"));
        }
        List<ContactObjects> before = app.getContactHelper().getContactList();
        app.getContactHelper().SelectContact(2);
        app.getContactHelper().submitDeleteContact();
        app.getContactHelper().goToAlert();
        app.getNavigationHelper().goToHome();
        List<ContactObjects>after= app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()-1);
    }
}