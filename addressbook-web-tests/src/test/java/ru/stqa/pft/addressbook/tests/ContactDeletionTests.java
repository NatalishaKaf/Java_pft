package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


    @Test
    public void GroupDeletionContacts() {
        app.getGroupHelper().goToFormContacts();
        app.getGroupHelper().submitDeleteContact();
        app.getGroupHelper().goToAlert();
        app.getNavigationHelper().goToHome();
    }
}