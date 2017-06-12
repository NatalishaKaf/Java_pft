package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInGroupDeleteTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("name").withLastname("lastname"));
        }
    }

    @Test
    public void testContactDeleteInGroup() {
        Groups groups = app.db().groups();
        if(groups.size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupObjects().withName("group_name"));
        }
        app.goTo().goToHome();
        app.contact().deleteContactInGroup(groups.iterator().next());
        app.goTo().goToHome();
    }

}
