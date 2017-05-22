package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().FormContacts();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactObjects().withFirstname("name").withMiddlename("middlename").withLastname("lastname").withNickname("nick").
                    withCompany("company").withAddresss("address").withEmail("g@mail.ru"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactObjects modifyContacts = before.iterator().next();
        //int index= before.size() - 1;
        ContactObjects contact = new ContactObjects().withId(modifyContacts.getId()).withFirstname("Наталья").withMiddlename("Владимировна").withLastname("Долгополова").
                withNickname("Natalisha").withTitle("Tester").withCompany("1C").withAddresss("Moscow").withHome("Korolev").
                withEmail("natalya-strel@yandex.ru");
        app.contact().modifyContacts(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        //before.remove(modifyContacts);
        //before.add(contact);
       /* Comparator<? super ContactObjects> byId= (b1, b2) -> Integer.compare(b1.getId(), b2.getId());
        before.sort(byId);
        after.sort(byId);*/
       // Assert.assertEquals(before,after);
        assertThat(after, equalTo(before.withOut(modifyContacts).withAdded(contact)));

    }



}
