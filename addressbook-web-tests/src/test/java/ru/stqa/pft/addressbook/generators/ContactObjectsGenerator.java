package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactObjects;


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
    
    @Parameter (names = "-o", description = "Objects file")
    public String format;
    public static void main(String[] args) throws IOException {
        ContactObjectsGenerator generator = new ContactObjectsGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactObjects> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unregnized format" + format);
        }
    }

    private void saveAsJson(List<ContactObjects> contacts, File file) throws IOException  {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(json);
        }
    }
    private static void saveAsCsv(List<ContactObjects> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)){
        for (ContactObjects contact : contacts) {
            writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getLastname(), contact.getPhones()));
        }
        }
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
