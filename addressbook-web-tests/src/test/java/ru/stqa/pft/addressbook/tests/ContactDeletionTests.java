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
        app.goTo().FormContacts();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactObjects().withFirstname("name").withMiddlename("middlename").withLastname("lastname").withNickname("nick").
                    withCompany("company").withAddresss("address").withEmail("g@mail.ru"));;
        }
    }


    @Test
    public void GroupDeletionContacts() {
        Contacts before = app.contact().all();
        ContactObjects deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(),equalTo( before.size()-1));
        Contacts after = app.contact().all();
        //before.remove(deletedContact);
        assertThat(after, equalTo(before.withOut(deletedContact)));
        //Assert.assertEquals(before, after);

    }


}