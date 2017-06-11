package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("name").withLastname("lastname"));
        }
    }

    @Test
    public void GroupDeletionContacts() {
        Contacts before = app.db().contacts();
        ContactObjects deletedContact = before.iterator().next();
        app.goTo().goToHome();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(),equalTo( before.size()-1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(deletedContact)));

    }


}