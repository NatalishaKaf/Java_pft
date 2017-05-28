package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactObjects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactObjectsGenerator {

    public static void main (String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List <ContactObjects> contacts = generateContacts(count);
        save (contacts, file);
    }

    private static void save(List<ContactObjects> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactObjects contact : contacts) {
            writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getLastname(), contact.getPhones()));
        }
        writer.close();
    }

    private static List<ContactObjects> generateContacts(int count) {
        List<ContactObjects> contacts = new ArrayList<ContactObjects>();
        for (int i=0; i<count; i++) {
            contacts.add(new ContactObjects()
                    .withFirstname(String.format("firstname %s", i)).withLastname(String.format("lastname %s", i))
                    .withPhones(String.format("phones %s", i)));
        }
        return contacts;

    }

}
