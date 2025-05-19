package DataDrivenTesting;







import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PropertiesFileReadWrite {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\New Text Document (3).txt";
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read JSON into Map
            Map<String, Object> data = mapper.readValue(new File(filePath), Map.class);

            // Read values
            String username = (String) data.get("username");
            String password = (String) data.get("password");

            System.out.println("Original username: " + username);
            System.out.println("Original password: " + password);

            // Modify values
            data.put("status", "active");
            data.put("password", "updated_" + password);

            // Write back to JSON file
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);

            System.out.println("JSON file updated.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
