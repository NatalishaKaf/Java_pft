package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void CreationTestContacts() {
        Contacts before = app.contact().all();
       ContactObjects contact = new ContactObjects().withFirstname("name").withMiddlename("middlename").withLastname("lastname").withNickname("nick").
               withCompany("company").withAddresss("address").withEmail("g@mail.ru").withGroup("test1");
        //ContactObjects contact = new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
          //      "address", "sdfsdf12355", null, "test1");
        app.contact().create(contact);
        Set<ContactObjects> after = app.contact().all();



        //int max = 0;
        /*for (ContactObjects g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }*/
        //Comparator<? super ContactObjects> ById= (Comparator<ContactObjects>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        //int max1= after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        //contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
       // before.add(contact);
       /* Comparator<? super ContactObjects> byId= (b1, b2) -> Integer.compare(b1.getId(), b2.getId());
        before.sort(byId);
        after.sort(byId);*/
       // Assert.assertEquals(before,after);
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));



    }
}

