package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("name").withLastname("lastname"));
        }
    }

    @Test
    public void testContactDeleteFromGroup() {
        Groups before = app.db().groups();
        GroupObjects groupInTopList = before.iterator().next();
        GroupObjects group = new GroupObjects().withId(groupInTopList.getId())
                .withName(groupInTopList.getName()).withHeader(groupInTopList.getHeader()).
                        withFooter(groupInTopList.getFooter());

        if (groupInTopList.getContacts().size() == 0) {
            app.goTo().goToHome();
            app.contact().create(new ContactObjects().withFirstname("firstname").withLastname("lastname").withPhones("phones").inGroup(group));
        }
        app.group().deleteContactInGroup(group);
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(groupInTopList).withAdded(group)));

    }
}