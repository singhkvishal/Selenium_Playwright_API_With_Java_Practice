package SQL;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature.*;

public class JsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException,Exception {
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");

        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

       // Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");

        // Now you can use next() on the ResultSet
        while (rs.next()) {
           /* System.out.println(rs.getString("CourseName"));
            System.out.println(rs.getString("PurchasedDate"));
            System.out.println(rs.getString("Amount"));
            System.out.println(rs.getString("Location"));*/

            CustomerDetails cd = new CustomerDetails();
            cd.setCourseName(rs.getString(1));
            cd.setPurchasedDate(rs.getString(2));
            cd.setAmount(rs.getInt(3));
            cd.setLocation(rs.getString(4));

            // Process the current row
            System.out.print(cd.getCourseName() + " ");
            System.out.print(cd.getCourseName()+" ");
            System.out.print(cd.getPurchasedDate()+" ");
            System.out.println(cd.getAmount()+" ");
        }

        // Create a list to hold all customer details
        List<CustomerDetails> customers = new ArrayList<>();
        
        // Reset the result set to the beginning
        rs.beforeFirst();
        
        // Process all rows
        while (rs.next()) {
            CustomerDetails cd = new CustomerDetails();
            cd.setCourseName(rs.getString(1));
            cd.setPurchasedDate(rs.getString(2));
            cd.setAmount(rs.getInt(3));
            cd.setLocation(rs.getString(4));
            customers.add(cd);
        }
        
        // Configure and use ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
       mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        String fileName = System.getProperty("user.dir") + "//test.json";
        
        // Write the list of customers to JSON file
        mapper.writeValue(new File(fileName), customers);

        // Don't forget to close resources
        rs.close();
        stmt.close();
        con.close();
    }
}