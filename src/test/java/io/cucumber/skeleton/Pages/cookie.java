package io.cucumber.skeleton.Pages;

import io.cucumber.skeleton.BasePage;
import io.cucumber.skeleton.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class cookie extends BasePage {
    WebDriver webDriver = Driver.getDriver();

    public void acceptSomeCookies() {
        webDriver.findElement(By.cssSelector("#onetrust-reject-all-handler")).click();
    }

    public void acceptAllCookies() {
        webDriver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
    }



    public int getCookieNumberr() {
        Set<Cookie> cookiesList = webDriver.manage().getCookies();
        System.out.println(cookiesList.size());
        return cookiesList.size();
    }

    public void goConfig() throws InterruptedException {
        webDriver.findElement(By.cssSelector("#onetrust-pc-btn-handler")).click();
        webDriver.findElement(By.cssSelector("#accept-recommended-btn-handler")).click();
    }
}
