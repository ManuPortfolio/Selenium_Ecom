package BaseTest;

import Practise.pageobjects.Landing_Page;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    public WebDriver driver;
    public Landing_Page landingP;

    public WebDriver IntializeDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }

    public List<HashMap<String, String>> getJsontoData(String FilePath) throws IOException {

        //Reading JSon File
        String JsonContent =  FileUtils.readFileToString(new File(FilePath),
                StandardCharsets.UTF_8);

        //Converting String into Hashmap values using Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;


    }

    @BeforeMethod(alwaysRun = true)
    public Landing_Page launchApplication(){
        System.out.println("===== BEFORE METHOD STARTED =====");
        driver = IntializeDriver();
        landingP = new Landing_Page(driver);
        System.out.println("Initialized landingP: " + landingP);
        landingP.goTo();
        return landingP;
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
