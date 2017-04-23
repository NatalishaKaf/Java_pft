package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionContacts extends TestBase {


    @Test
    public void GroupDeletionContacts() {
        app.goToFormContacts();
        app.submitDeleteContact();
        app.goToAlert();
        app.goToHome();
    }
}
