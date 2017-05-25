package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones() {
        app.goTo().FormContacts();
        ContactObjects contact = app.contact().all().iterator().next();
        ContactObjects contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

  private String mergePhones(ContactObjects contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilPhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");

    }

}