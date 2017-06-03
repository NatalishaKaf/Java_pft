package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactObjects;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupObjects;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionContactTest {

    @Test
    public void testDbConnectoin() {
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:/addressbook?serverTimezone=UTC&user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs= st.executeQuery("select id, firstname, lastname, home from addressbook");
            Contacts contacts = new Contacts();
            while(rs.next()){
               contacts.add(new ContactObjects().withId(rs.getInt("id")).withFirstname(rs.getString("firstname"))
                        .withLastname(rs.getString("lastname")).withPhones(rs.getString("home")));
            }
            rs.close();;
            st.close();;
            conn.close();;

            System.out.println(contacts);


            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
