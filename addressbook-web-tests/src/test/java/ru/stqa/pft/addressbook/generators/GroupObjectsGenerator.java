package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.org.jvnet.staxex.XMLStreamWriterEx;
import ru.stqa.pft.addressbook.model.GroupObjects;

import javax.xml.stream.XMLStreamConstants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupObjectsGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-o", description = "Objects file")
    public String format;

   public static void main(String[] args) throws IOException {
        GroupObjectsGenerator generator = new GroupObjectsGenerator();
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
        List<GroupObjects> groups = generateGroups(count);
       if (format.equals("csv")) {
            saveAsCsv(groups, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(groups, new File(file));
        } else {
            System.out.println("Unregnized format" + format);
        }
    }

    private void saveAsJson(List<GroupObjects> groups, File file) throws IOException  {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static void saveAsCsv(List<GroupObjects> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (GroupObjects group : groups) {
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();
    }

    private static List<GroupObjects> generateGroups(int count) {
        List<GroupObjects> groups = new ArrayList<GroupObjects>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupObjects().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;

    }

}
