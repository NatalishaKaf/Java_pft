package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionContacts extends TestBase {


    @Test
    public void GroupDeletionContacts() {
        goToFormContacts();
        submitDeleteContact();
        goToAlert();
        goToHome();
    }
}
