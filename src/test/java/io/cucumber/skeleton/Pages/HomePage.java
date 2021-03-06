package io.cucumber.skeleton.Pages;
import io.cucumber.skeleton.BasePage;
import io.cucumber.skeleton.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {
    private String url="https://www2.hm.com/es_es/index.html";

    WebDriver webDriver = Driver.getDriver();

    @FindBy(id="search_query_top")
    private WebElement productSearch;

    private void sleep(double x){
        try {
            Thread.sleep((long) (x* 1000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public HomePage openSpringfieldURL(){
        webDriver.get(url);
        WebElement cookies=webDriver.findElement(By.id("onetrust-reject-all-handler"));
        cookies.click();
        return this;
    }
    public void findProduct(String product){
        //encuentra el boton de busqueda
        WebElement searchBox=webDriver.findElement(By.id("main-search"));
        //ingresamos lo que queremos buscar
        searchBox.sendKeys(product);
        searchBox.submit();

    }
    public void buyProduct(int i){
        WebElement product=webDriver.findElements(By.cssSelector("article .image-container a img")).get(i);
        product.click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        webDriver.findElement(By.cssSelector(".product-button-wrapper button")).click();
        sleep(3);
        webDriver.findElements(By.cssSelector(".picker-option button span")).get(3).click();
        sleep(3);
        webDriver.findElement(By.cssSelector("#main-content > div.product.parbase > div.layout.pdp-wrapper.product-detail.sticky-footer-wrapper.js-reviews > div.module.product-description.sticky-wrapper > div.sub-content.product-detail-info.product-detail-meta.inner.sticky-on-scroll.semi-sticky > div > div.product-item-buttons > div.product-button-wrapper > button")).click();
        sleep(3);
        webDriver.navigate().back();
    }
    public void go_home(){
        WebElement product= webDriver.findElement(By.cssSelector("body > header > nav > a.menu__hm"));
        product.click();
    }
    public boolean checkCartValue(double x){
        WebElement cart = webDriver.findElement(By.cssSelector(".minicart a"));
        cart.click();
        sleep(2);
        WebElement val=webDriver.findElement(By.cssSelector("#sidebar-sticky-boundary > section.CartSidebar--wrapper__2D7xe.CartSidebar--reactCheckoutEnabledUpdatedSidebar__JyGkt > div > div > div.CartSidebar--sidebarContent__3nsmD.CartSidebar--isNotCompressedSidebar__1l9b2 > div.FadeIn-module--container__3nvOo.undefined > table > tfoot > tr > td"));
        System.out.println(val.getText());
        double price = Double.parseDouble(val.getText().replace(',','.').replace('???',' '));
        return x == price;
    }
    public void chooseProduct(String p){
        String text=webDriver.findElement(By.xpath("//*[@id='page-content']/div[1]/ul/li[1]/article/div[2]/h3/a")).getText();
        if(text.contains(p)){
            webDriver.findElement(By.xpath("//*[@id='page-content']/div[1]/ul/li[1]/article/div[2]/h3/a")).click();
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        }
        else{
            //click on product
            System.out.println("There is not " + p + " test in the found string");
        }
    }
    public void selectSize() throws InterruptedException {
        WebElement buttonSize=webDriver.findElement(By.cssSelector("#picker-1 > button"));
        Thread.sleep(3000);
        buttonSize.click();
        Thread.sleep(3000);
        //selSize=webDriver.findElement(By.cssSelector("#picker-1 > ul > li:nth-child(2) > div > button"));
        WebElement selSize=webDriver.findElement(By.cssSelector("#picker-1 > ul > li:nth-child(3) > div > button"));
        selSize.click();
    }
    public void addToCart() throws InterruptedException {
        Thread.sleep(1000);

        WebElement buttonAdd=webDriver.findElement(By.cssSelector("#main-content > div.product.parbase > div.layout.pdp-wrapper.product-detail.sticky-footer-wrapper.js-reviews > div.module.product-description.sticky-wrapper > div.sub-content.product-detail-info.product-detail-meta.inner.sticky-on-scroll.semi-sticky > div > div.product-item-buttons > div.product-button-wrapper > button"));
        Thread.sleep(3000);

        System.out.println("buttonAdd");
        System.out.println(buttonAdd);
        buttonAdd.click();
    }
    public int validateShoppingCart() throws InterruptedException {
        WebElement countBag=webDriver.findElement(By.className("shoppingbag-item-count"));
        System.out.println("countBag");
        System.out.println(countBag);
        Thread.sleep(3000);
        String cBag=countBag.getText();
        Thread.sleep(2000);
        int intCountBag=Integer.parseInt(cBag);
        System.out.println("intCountBag");
        System.out.println(intCountBag);
        return intCountBag;
    }
    public void isHome() {
        assertEquals(webDriver.getCurrentUrl(), "https://www2.hm.com/es_es/index.html");
    }

    public void go_toMenuItem(String s) {
        List<WebElement> elems = webDriver.findElements(By.cssSelector("body > header > nav > ul.menu__primary > li"));
        elems.get(Integer.parseInt(s)+1).click();
    }

    public void register(String arg0, String arg1) {
        webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__session > li:nth-child(1) > div > a:nth-child(1)")).click();
        sleep(1);
        webDriver.findElement(By.cssSelector("body > div.has-closebutton.is-popup.has-max-width.has-min-width.has-animate.has-ajax-url.remodal.club-modal-forms.remodal-open.remodal-active > div > div > button")).click();
        sleep(1);
        webDriver.findElement(By.cssSelector("#modal-signin-email")).sendKeys(arg0);
        sleep(1);
        webDriver.findElement(By.cssSelector("#modal-signin-password")).sendKeys(arg1);
        sleep(1);
        webDriver.findElement(By.cssSelector("#modal-signin-day")).sendKeys("25");
        webDriver.findElement(By.cssSelector("#modal-signin-month")).sendKeys("10");
        webDriver.findElement(By.cssSelector("#modal-signin-year")).sendKeys("2000");
        webDriver.findElement(By.cssSelector("body > div.has-closebutton.is-popup.has-max-width.has-min-width.has-animate.has-ajax-url.remodal.club-modal-forms.remodal-open.remodal-active > div > div > div > form > button")).click();
        sleep(2);

    }

    public void go_to_find_shop(String s) throws InterruptedException {
        webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__primary > div > div:nth-child(3) > a")).click();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        sleep(2);
        webDriver.findElement(By.cssSelector("#addressAutocomplete")).sendKeys(s);
        Thread.sleep(2000);
    }

    public boolean city_found(String city){
        webDriver.findElement(By.xpath("//*[text()=" + city + "]"));
        return true;
    }

    public boolean registerSuccess() {
        try{
            webDriver.findElement(By.cssSelector("#modal-signin-email-email-format-error"));
            return false;
        }catch (Exception e){
            try {

            }catch (Exception e2){
                webDriver.findElement(By.cssSelector("#modal-signin-password-tips-fullfilled-error"));
                return false;
            }
            return true;
        }
    }

    public void addFavorite(int i) {
        for(int j = 0; j<i; j++){
            WebElement product=webDriver.findElements(By.cssSelector("article .image-container a img")).get(j);
            product.click();
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

            webDriver.findElement(By.cssSelector("#favourite_")).click();
            sleep(2);
            webDriver.navigate().back();
        }

    }

    public int getNFavs() {
        try {
            webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__session > li:nth-child(3) > a")).click();
            sleep(1);
            WebElement el=webDriver.findElement(By.cssSelector("#main-content > div.FadeInOut-module--container__1hPKG.FadeInOut-module--entered__3Jpc2 > p"));
            System.out.println(el.getText());
            return  Integer.parseInt(el.getText().split(" ")[0]);
        }catch (Exception e){
            return 0;
        }

    }


    public void go_to_newsletter() {
        webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__primary > div > div:nth-child(2) > a")).click();
    }

    public void submit_news(String mail, String gender, String pc) {
        webDriver.findElement(By.cssSelector("#txt-email")).sendKeys(mail);
        sleep(0.5);
        if(Objects.equals(gender, "male"))
            webDriver.findElement(By.cssSelector("#newsletter-i-am-gender-male")).click();
        else
            webDriver.findElement(By.cssSelector("#newsletter-i-am-gender-female")).click();
        sleep(0.5);
        webDriver.findElement(By.cssSelector("#txt-postal-code")).sendKeys(pc);
        sleep(0.5);
        webDriver.findElement(By.cssSelector("#cs-fashion-news")).click();
        sleep(2);
        webDriver.findElement(By.cssSelector("#newsletterForm > div.newsletter-thankyou-form > input")).click();
        sleep(2);


    }

    public void isNewsSuccess() {
        assertEquals(webDriver.getCurrentUrl(), "https://www2.hm.com/es_es/customer-service/thank-you.html?statusCode=success");

    }

    public void isNewsRepeated() {
        assertEquals(webDriver.getCurrentUrl(), "https://www2.hm.com/es_es/customer-service/thank-you.html?statusCode=alreadySubscribed");
    }

    public void go_to_suport(String s) {
        sleep(2);
        webDriver.get("https://www2.hm.com/es_es/service-clients.html");
        sleep(1);
        switch (s){
            case "Entrega": webDriver.findElement(By.cssSelector("#page-content > div > div:nth-child(4) > div > p:nth-child(1) > a")).click();break;
            case "Pagos": webDriver.findElement(By.cssSelector("#page-content > div > div:nth-child(4) > div > p:nth-child(2) > a")).click();break;
            case "Devoluciones": webDriver.findElement(By.cssSelector("#page-content > div > div:nth-child(4) > div > p:nth-child(3) > a")).click();break;
            case "Contacta": webDriver.findElement(By.cssSelector("#page-content > div > div:nth-child(5) > div > p:nth-child(1) > a")).click();break;
        }
    }

    public boolean is_suport_correct(String s) {
        String url = "https://www2.hm.com/es_es/service-clients/shippinganddelivery.html";
        switch (s){
            case "Entrega": url = "https://www2.hm.com/es_es/service-clients/shippinganddelivery.html";
            case "Pagos": url = "https://www2.hm.com/es_es/service-clients/payments-info.html";
            case "Devoluciones": url = "https://www2.hm.com/es_es/service-clients/returns.html";
            case "Contacta": url = "https://www2.hm.com/es_es/service-clients/contact.html";
        }
        return s.equals(url);
    }
}
