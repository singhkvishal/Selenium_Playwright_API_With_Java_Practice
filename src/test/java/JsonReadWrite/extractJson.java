package JsonReadWrite;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class extractJson {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Read JSON array into a List of CustomerDetails objects
        List<CustomerDetails> customers = objectMapper.readValue(
            new File(System.getProperty("user.dir") + "\\test.json"),
            new TypeReference<>() {}
        );

        // Print details of each customer
        for (CustomerDetails customer : customers) {
            System.out.println("Course Name: " + customer.getCourseName());
            System.out.println("Amount: " + customer.getAmount());
            System.out.println("Location: " + customer.getLocation());
            System.out.println("Purchased Date: " + customer.getPurchasedDate());
            
            // Display discount information if available
            CustomerDetails.Discount discount = customer.getDiscount();
            if (discount != null) {
                System.out.println("Discount:");
                System.out.println("  - Discounted Amount: " + discount.getDiscountedAmount());
                System.out.println("  - Discount Percentage: " + discount.getDiscountPercentage() + "%");
            }
            
            System.out.println("----------------------");
        }
    }
}