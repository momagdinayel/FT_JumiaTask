package org.example.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Hooks {
    public static WebDriver driver;
    @Before
    public static void open_browser(){
//        String browser = System.getProperty("user.dir") + File.separator + "src"
//                + File.separator + "main" + File.separator
//                + "resources" + File.separator + "chromedriver.exe";
//        String browser=System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver",browser);
//        driver=new ChromeDriver();

//        String edge=System.getProperty("user.dir")+"/src/main/resources/msedgedriver.exe";
//        System.setProperty("webdriver.edge.driver",edge);
//        driver=new EdgeDriver();

        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.jumia.com.eg/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

    }

    @After
    public static void quit_browser(){
        driver.quit();
    }
}
