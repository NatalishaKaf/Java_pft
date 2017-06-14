package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactObjects> contacts = gson.fromJson(json, new TypeToken<List<ContactObjects>>() {
            }.getType()); //List<GroupObjects>.class
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }


    @Test (dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactObjects contact) {
        Contacts before = app.db().contacts();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
       /* assertThat(after, equalTo(before.withAdded(contact.withId(after.stream()
                .mapToInt((c) -> c.getId()).max().getAsInt()))));*/
        verifyContactListInUi();
    }

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


