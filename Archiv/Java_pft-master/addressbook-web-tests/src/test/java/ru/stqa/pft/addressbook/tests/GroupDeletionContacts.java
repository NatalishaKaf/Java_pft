package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionContacts extends TestBase {


    @Test
    public void GroupDeletionContacts() {
        app.getGroupHelper().goToFormContacts();
        app.getGroupHelper().submitDeleteContact();
        app.getGroupHelper().goToAlert();
        app.getGroupHelper().goToHome();
    }
}