/*
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

public class ContactInGroupAddTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("name").withLastname("lastname"));
        }
    }

    @Test
    public void testContactAddInGroup() {
        Groups groups = app.db().groups();
        if(groups.size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupObjects().withName("group_name"));
        }
        app.goTo().goToHome();
        Contacts before = app.db().contacts();
        ContactObjects modifyContacts = before.iterator().next();
        //int index= before.size() - 1;
        ContactObjects contact = new ContactObjects().withId(modifyContacts.getId()).withFirstname("Наталья").withMiddlename("Владимировна").withLastname("Долгополова").
                withNickname("Natalisha").withTitle("Tester").withCompany("1C").withAddress("Moscow").withHome("Korolev").
                withEmail("natalya-strel@yandex.ru");
        app.contact().addContactInGroup(contact);
        app.goTo().goToHome();
        verifyContactListInUi();
    }

}
*/
