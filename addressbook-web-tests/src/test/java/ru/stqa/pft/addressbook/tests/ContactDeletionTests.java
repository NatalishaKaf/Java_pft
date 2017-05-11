package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

public class ContactDeletionTests extends TestBase {


    @Test
    public void GroupDeletionContacts() {
        app.getContactHelper().goToFormContacts();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                    "address", "sdfsdf12355", null, "test1"));
        }
        app.getContactHelper().SelectContact();
        app.getContactHelper().submitDeleteContact();
        app.getContactHelper().goToAlert();
        app.getNavigationHelper().goToHome();
        int after= app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before-1);
    }
}