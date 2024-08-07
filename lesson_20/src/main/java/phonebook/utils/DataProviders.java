package phonebook.utils;

import org.testng.annotations.DataProvider;
import phonebook.model.Contact;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addContactString() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Name1", "LastName1", "1234567891", "admin1@gmail.com", "Germany, Berlin1", "Description 1"});
        list.add(new Object[]{"Name2", "LastName2", "1234567892", "admin2@gmail.com", "Germany, Berlin2", "Description 2"});
        list.add(new Object[]{"Name3", "LastName3", "1234567893", "admin3@gmail.com", "Germany, Berlin3", "Description 3"});
        list.add(new Object[]{"Name4", "LastName4", "1234567894", "admin4@gmail.com", "Germany, Berlin4", "Description 4"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactObject() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new Contact().setName("Name1").setLastName("LastName1").setPhone("1234567891").setEmail("admin1@gmail.com").setAddress("Germany, Berlin1").setDescription("Description 1")});
        list.add(new Object[]{new Contact().setName("Name2").setLastName("LastName2").setPhone("1234567892").setEmail("admin2@gmail.com").setAddress("Germany, Berlin2").setDescription("Description 2")});
        list.add(new Object[]{new Contact().setName("Name3").setLastName("LastName3").setPhone("1234567893").setEmail("admin3@gmail.com").setAddress("Germany, Berlin3").setDescription("Description 3")});
        list.add(new Object[]{new Contact().setName("Name4").setLastName("LastName4").setPhone("1234567894").setEmail("admin4@gmail.com").setAddress("Germany, Berlin4").setDescription("Description 4")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/Contacts.csv"));
        String line = reader.readLine();
        while (line !=null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                            new Contact()
                                    .setName(split[0])
                                    .setLastName(split[1])
                                    .setPhone(split[2])
                                    .setEmail(split[3])
                                    .setAddress(split[4])
                                    .setDescription(split[5])
                    }
            );
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}
