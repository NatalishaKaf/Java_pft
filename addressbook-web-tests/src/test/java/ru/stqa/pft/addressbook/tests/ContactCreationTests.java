package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new ContactObjects().withFirstname("firstname1").withLastname("lastname1").withPhones("phones1")});
        list.add(new Object[]{new ContactObjects().withFirstname("firstname2").withLastname("lastname2").withPhones("phones2")});
        list.add(new Object[]{new ContactObjects().withFirstname("firstname3").withLastname("lastname3").withPhones("phones3")});
        return list.iterator();
    }


    @Test (dataProvider = "validContacts")
    public void testContactCreation(ContactObjects contact) {
        Contacts before = app.contact().all();
       // File photo = new File("src/test/resources/stru");
        //ContactObjects contact = new ContactObjects().withFirstname("name").withMiddlename("middlename").withLastname("lastname").withNickname("nick").
              //  withCompany("company").withAddress("address").withEmail("g@mail.ru").withPhoto(photo);
        //ContactObjects contact = new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
        //      "address", "sdfsdf12355", null, "test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }



        //int max = 0;
/*for (ContactObjects g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }*//*

        //Comparator<? super ContactObjects> ById= (Comparator<ContactObjects>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        //int max1= after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        //contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        // before.add(contact);
       */
/* Comparator<? super ContactObjects> byId= (b1, b2) -> Integer.compare(b1.getId(), b2.getId());
        before.sort(byId);
        after.sort(byId);*/

        // Assert.assertEquals(before,after);

    @Test (enabled = false)
    public void CreationBadTestContacts() {
        Contacts before = app.contact().all();
      //File photo = new File("src/test/resources/stru");
        ContactObjects contact = new ContactObjects().withFirstname("firstname").withLastname("lastname").withPhones("phones");
       // ContactObjects contact = new ContactObjects().withFirstname("name").withMiddlename("middlename").withLastname("lastname").withNickname("nick").
               // withCompany("company").withAddress("address").withEmail("g@mail.ru");
                //.withPhoto(photo);
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

   @Test (enabled = false)
    public void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/stru");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}


