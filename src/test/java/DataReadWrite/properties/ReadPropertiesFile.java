package DataReadWrite.properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
    public static void main(String[] args) {
        String outputPath=System.getProperty("user.dir")+"\\src\\test\\java\\DataReadWrite\\properties\\myFile.properties";
        try (InputStream input = new FileInputStream(outputPath)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("name"));
            System.out.println(prop.getProperty("Address"));
            System.out.println(prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
