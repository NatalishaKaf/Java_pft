package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;

public class ContactModificationTests extends TestBase {
    @Test

    public void testContactModification () {
        app.getGroupHelper().goToFormContacts();
        app.getGroupHelper().initContactModification();
        app.getGroupHelper().fillFormContact(new ContactObjects("Наталья", "ДНВ", "Долгополова", "Natalisha",
                "Tester", "1C", "Moscow", "Korolev", "natalya-strel@yandex.ru", null), false);
        app.getGroupHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
        app.getGroupHelper().initContactView();
        app.getGroupHelper().initContactModifiy();
       // testContactModification ()
        app.getGroupHelper().submitContactModification();
        app.getNavigationHelper().goToHome();
    }

}
