package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactEmailTests extends TestBase  {

    @Test
    public void testContactEmail() {
        app.goTo().FormContacts();
        ContactObjects contact = app.contact().all().iterator().next();
        ContactObjects contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
    }

}