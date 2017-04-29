package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test

    public void testContactModification () {
        app.getGroupHelper().goToFormContacts();
        app.getGroupHelper().initContactModification();
        app.getGroupHelper().fillFormContact("Наталья", "ДНВ", "Долгополова", "Natalisha",
                "Tester", "1C", "Moscow", "Korolev", "natalya-strel@yandex.ru");
        app.getGroupHelper().submitContactModification();
        app.getGroupHelper().goToHome();
        app.getGroupHelper().initContactView();
        app.getGroupHelper().initContactModifiy();
       // testContactModification ()
        app.getGroupHelper().submitContactModification();
        app.getGroupHelper().goToHome();
    }

}
