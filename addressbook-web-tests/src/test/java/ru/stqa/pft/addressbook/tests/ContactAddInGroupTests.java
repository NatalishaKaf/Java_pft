package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddInGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupObjects().withName("test1"));
        }

        if (app.db().contacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("name").withLastname("lastname"));
        }
    }

    @Test
    public void testContactAddInGroup() {
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        ContactObjects contactToAdd = before.iterator().next();
        ContactObjects contact = new ContactObjects().withId(contactToAdd.getId()).withFirstname("Наталья").withMiddlename("Владимировна").withLastname("Долгополова").
                withNickname("Natalisha").withTitle("Tester").withCompany("1C").withAddress("Moscow").withHome("Korolev").
                withEmail("natalya-strel@yandex.ru");
        app.contact().addToGroup(contact);
        app.goTo().goToHome();
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(contactToAdd).withAdded(contact.withGroups(groups))));
    }

}
