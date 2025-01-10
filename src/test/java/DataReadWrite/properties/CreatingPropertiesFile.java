package DataReadWrite.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreatingPropertiesFile {
    public static void main(String args[]) throws IOException {
        String outputPath=System.getProperty("user.dir")+"\\src\\test\\java\\DataReadWrite\\properties\\TestData.xml";

        //Instantiating the properties file
        Properties props = new Properties();
        //Populating the properties file
        props.put("Device_name", "OnePlus7");
        props.put("Android_version", "9");
        props.put("Model", "GM1901");
        props.put("CPU", "Snapdragon855");
        //Instantiating the FileInputStream for output file

        FileOutputStream outputStrem = new FileOutputStream(outputPath);
        //Storing the properties file in XML format
        props.storeToXML(outputStrem, "This is a sample properties file");
        System.out.println("Properties file created......");
    }
}
