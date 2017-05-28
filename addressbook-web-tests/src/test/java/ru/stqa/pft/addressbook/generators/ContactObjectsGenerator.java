package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.GroupObjects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactObjectsGenerator {

    @Parameter(names = "-c", description = "Group count")
    public  int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    public static void main (String[] args) throws IOException {
        ContactObjectsGenerator generator = new ContactObjectsGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        }catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactObjects> contacts = generateContacts(count);
        save (contacts, new File(file));
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
