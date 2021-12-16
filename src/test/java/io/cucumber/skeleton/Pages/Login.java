package io.cucumber.skeleton.Pages;

import io.cucumber.skeleton.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;

public class Login extends HomePage {
    Driver driver = new Driver();
    WebDriver webDriver = Driver.getDriver();
    private boolean alreadyout;

    public void login(User user) throws InterruptedException {
        boolean correctLog=false;

        WebElement buttonLogin=webDriver.findElement(By.xpath("/html/body/header/nav/ul[1]/li[1]/div/a[1]"));
        Thread.sleep(1000);
        buttonLogin.click();
        Thread.sleep(1000);

        WebElement elUser=webDriver.findElement(By.id("modal-txt-signin-email"));
        Thread.sleep(1000);
        elUser.sendKeys(user.getUser());
        Thread.sleep(1000);

        WebElement elPass=webDriver.findElement(By.id("modal-txt-signin-password"));
        Thread.sleep(1000);
        elPass.sendKeys(user.getPass());
        Thread.sleep(1000);

        webDriver.findElement(By.cssSelector("#modal-theLoginForm > button")).click();

        String gmail1=user.getUser();
        String gmail2="nuriamba17@gmail.com";
        String pass1=user.getPass();
        String pass2="Creacontra1";
        if(!gmail1.equals(gmail2)){
            System.out.println("USER INCORRECT");
            System.out.println("is the alert displayed?");
            Thread.sleep(10000);
            System.out.println(webDriver.findElement(By.id("modal-txt-signin-password-unknown-error-type-error")).isDisplayed());
        }else{
            if(!pass1.equals(pass2)){
                System.out.println("PASSWORD INCORRECT");
                System.out.println("is the alert displayed?");
                Thread.sleep(10000);
                System.out.println(webDriver.findElement(By.id("modal-txt-signin-password-unknown-error-type-error")).isDisplayed());
            }else {
                correctLog=true;
                System.out.println("USER AND PASSWORD CORRECT");
            }

        }
        if(!correctLog){
            WebElement cross=webDriver.findElement(By.cssSelector("body > div.has-closebutton.is-popup.has-max-width.has-min-width.has-animate.has-ajax-url.remodal.club-modal-forms.remodal-open.remodal-active > div > button"));
            System.out.println("cross");
            System.out.println(cross);
            Thread.sleep(3000);
            cross.click();
        }
    }
    public boolean isLogged() throws InterruptedException {
        boolean logged=false;
        WebElement buttonlogout=webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__session > li:nth-child(1) > div > a:nth-child(2)"));
        Thread.sleep(10000);
        logged=buttonlogout.isDisplayed();
        return logged;
    }
    public void logout() throws InterruptedException {
        try {
            Thread.sleep(3000);
            webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__session > li:nth-child(1) > div > a:nth-child(2)")).click();
            Thread.sleep(3000);
            webDriver.findElement(By.cssSelector("#app > div > div > div > div > aside > div:nth-child(3) > nav > ul > li:nth-child(3) > a")).click();
        }catch (Exception e) {
            alreadyout = true;
        }
    }

    public boolean alreadyout() {
        return alreadyout;
    }
}