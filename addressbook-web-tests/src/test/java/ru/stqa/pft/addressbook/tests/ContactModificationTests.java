package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

public class ContactModificationTests extends TestBase {
    @Test

    public void testContactModification () {
        app.getContactHelper().goToFormContacts();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactObjects("fgdfg", "xfdgfg", "xcv", "dfg", null, "cvbvcb",
                    "address", "sdfsdf12355", null, "test1"));
        }
        app.getContactHelper().SelectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillFormContact(new ContactObjects("Наталья", "ДНВ", "Долгополова", "Natalisha",
                "Tester", "1C", "Moscow", "Korolev", "natalya-strel@yandex.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
        app.getContactHelper().initContactView();
        app.getContactHelper().initContactModifiy();
       // testContactModification ()
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
        int after= app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before);
    }

}
