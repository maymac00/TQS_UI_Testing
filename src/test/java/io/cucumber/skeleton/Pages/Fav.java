package io.cucumber.skeleton.Pages;

import io.cucumber.skeleton.BasePage;
import io.cucumber.skeleton.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Fav extends BasePage {
    Driver driver = new Driver();
    WebDriver webDriver = driver.getDriver();

    public void chooseFavourite() throws InterruptedException {
        WebElement f=webDriver.findElement(By.id("favourite_"));
        Thread.sleep(3000);
        f.click();
    }
    public boolean validateFav() throws InterruptedException {
        WebElement fv=webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__session > li:nth-child(3) > a"));
        Thread.sleep(3000);
        fv.click();
        Thread.sleep(3000);
        boolean article=webDriver.findElement(By.cssSelector("#main-content > div.FadeInOut-module--container__1hPKG.FadeInOut-module--entered__3Jpc2 > p > span")).isDisplayed();
        Thread.sleep(3000);
        return article;
    }
    public void deleteFavourite(int n) throws InterruptedException {
        webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__session > li:nth-child(3) > a")).click();
        for(int i = 0; i<n; i++){
            Thread.sleep(1000);
            try{
                List<WebElement> del=webDriver.findElements(By.cssSelector("#main-content > div > ul > li > article > div > div > button"));
                Thread.sleep(1000);
                del.get(0).click();
            }catch (Exception e){
                break;
            }
        }

    }
    public boolean validateDeleteFav() throws InterruptedException {
        WebElement df=webDriver.findElement(By.cssSelector("#main-content > div.FadeInOut-module--container__1hPKG.FadeInOut-module--entered__3Jpc2 > div > h2 > span"));
        Thread.sleep(4000);
        boolean delete=df.isDisplayed();
        Thread.sleep(4000);
        return delete;
    }
}