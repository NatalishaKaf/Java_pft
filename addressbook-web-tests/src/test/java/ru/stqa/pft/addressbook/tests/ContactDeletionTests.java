package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().goToFormContacts();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                    "address", "sdfsdf12355", null, "test1"));
        }
    }


    @Test
    public void GroupDeletionContacts() {
        List<ContactObjects> before = app.getContactHelper().getContactList();
        app.getContactHelper().SelectContact(before.size() - 1);
        app.getContactHelper().submitDeleteContact();
        app.getContactHelper().goToAlert();
        app.getContactHelper().goToHome();
        List<ContactObjects> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}