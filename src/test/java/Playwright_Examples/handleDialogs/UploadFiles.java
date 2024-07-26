package Playwright_Examples.handleDialogs;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFiles {

    @Test
    public void Test(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        //1-Upload Single File
        page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));


        //2- Remove the File
        page.setInputFiles("input#filesToUpload", new Path[0]);

        //3- Upload Multipal Files

        page.setInputFiles("input#filesToUpload", new Path[]{
                Paths.get("applogin.json"),
                Paths.get("auth.json"),
                Paths.get("pom.xml")
        });

        //4- Remove all the Files
        page.setInputFiles("input#filesToUpload", new Path[0]);

        //5- Run time file - Upload
        page.setInputFiles("input#filesToUpload",new FilePayload("Vishal.text","text/plain","This is Vishal Here".getBytes(StandardCharsets.UTF_8)));

    }
}
