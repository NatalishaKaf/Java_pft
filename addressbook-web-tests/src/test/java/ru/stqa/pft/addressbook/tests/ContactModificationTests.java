package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.*;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().FormContacts();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactObjects().withFirstname("name").withMiddlename("middlename").withLastname("lastname").withNickname("nick").
                    withCompany("company").withAddresss("address").withEmail("g@mail.ru"));
        }
    }

    @Test
    public void testContactModification() {
        List<ContactObjects> before = app.contact().list();
        int index= before.size() - 1;
        ContactObjects contact = new ContactObjects().withId(before.get(index).getId()).withFirstname("Наталья").withMiddlename("Владимировна").withLastname("Долгополова").
                withNickname("Natalisha").withTitle("Tester").withCompany("1C").withAddresss("Moscow").withHome("Korolev").
                withEmail("natalya-strel@yandex.ru");
        app.contact().modifyContacts(index, contact);
        List<ContactObjects> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactObjects> byId= (b1, b2) -> Integer.compare(b1.getId(), b2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }



}
