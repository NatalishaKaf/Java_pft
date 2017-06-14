package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("firstname").withLastname("lastname")
                    .withAddress("Korolev")
                    .withWorkPhone("495-11-22").withMobilPhone("+799999999").withHomePhone("495-22-33"));
        }
        app.goTo().goToHome();
    }

    @Test
    public void testContactInfo() {
        app.goTo().goToHome();
        ContactObjects contact = app.db().contacts().iterator().next();
        ContactObjects infoFromEditForm = app.contact().infoFromEditForm(contact);
        String expected = Arrays.stream(new String[]
                {infoNames(infoFromEditForm)
                        ,infoFromEditForm.getAddress()
                        , infoPhones(infoFromEditForm)})
                .filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
        String contactDetails = cleanedPhones(app.contact().contactObjectfromDetailsForm(contact));
        assertThat(contactDetails, equalTo(expected));
    }


    private String infoPhones(ContactObjects contact) {
        return Arrays.stream(new String[]{contact.getHomePhone(), contact.getMobilPhone(), contact.getWorkPhone()})
                .filter((s) -> ! s.equals(""))
                .map(ContactInfoTests::cleanedPhones)
                .collect(Collectors.joining("\n"));
    }


    private String infoNames(ContactObjects contact) {
        return Arrays.stream(new String[]{contact.getFirstname(), contact.getLastname()})
                .filter((n) -> ! n.equals("")).collect(Collectors.joining(" "));
    }

    private static String cleanedPhones(String phone) {
        return phone.replaceAll("[HMW]\\:\\ ", "").replaceAll("[\\n]{2,}", "\n");
    }
}