package io.cucumber.skeleton;

import io.cucumber.java.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver d){
        Driver.driver=d;
    }

    //Para realizar una instancia del driver
    @Before
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        Dimension dimension = new Dimension(1920, 1080);
        driver=new ChromeDriver();
        driver.manage().window().setSize(dimension);
    }

    //Para quitarlo cuando finalice la prueba
    @After
    public static void closeBrowser() throws Exception{
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
