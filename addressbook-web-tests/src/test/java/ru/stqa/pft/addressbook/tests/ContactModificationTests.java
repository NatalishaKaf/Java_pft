package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("name").withLastname("lastname"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactObjects modifyContacts = before.iterator().next();
        //int index= before.size() - 1;
        ContactObjects contact = new ContactObjects().withId(modifyContacts.getId()).withFirstname("Наталья").withMiddlename("Владимировна").withLastname("Долгополова").
                withNickname("Natalisha").withTitle("Tester").withCompany("1C").withAddress("Moscow").withHome("Korolev").
                withEmail("natalya-strel@yandex.ru");
        app.goTo().goToHome();
        app.contact().modifyContacts(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifyContacts).withAdded(contact)));
        verifyContactListInUi();

    }

}
