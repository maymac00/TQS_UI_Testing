package io.cucumber.skeleton.Pages;
import io.cucumber.skeleton.BasePage;
import io.cucumber.skeleton.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddInCart extends BasePage {

    Driver driver = new Driver();
    WebDriver webDriver = Driver.getDriver();

    public AddInCart openSpringfieldURL(){
        webDriver.get("https://www2.hm.com/es_es/index.html");
        return this;
    }
    public void findProduct(String product){
        //encuentra el boton de busqueda
        WebElement searchBox=webDriver.findElement(By.name("q"));
        //ingresamos lo que queremos buscar
        searchBox.sendKeys(product);
        searchBox.submit();
    }
    public void chooseProduct(String p){
        String text=webDriver.findElement(By.xpath("//*[@id='page-content']/div[1]/ul/li[1]/article/div[2]/h3/a")).getText();
        if(text.contains(p)){
            webDriver.findElement(By.xpath("//*[@id='page-content']/div[1]/ul/li[1]/article/div[2]/h3/a")).click();
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
        WebElement buttonAdd=webDriver.findElement(By.cssSelector("#main-content > div.product.parbase > div.layout.pdp-wrapper.product-detail.sticky-footer-wrapper.js-reviews.fill-me-up > div.module.product-description.sticky-wrapper > div.sub-content.product-detail-info.product-detail-meta.inner.sticky-on-scroll.semi-sticky.sticky > div > div.product-item-buttons > div.product-button-wrapper > button"));
        Thread.sleep(3000);
        //boolean notStock=webDriver.findElement(By.cssSelector("#main-content > div.product.parbase > div.layout.pdp-wrapper.product-detail.sticky-footer-wrapper.js-reviews > div.module.product-description.sticky-wrapper > div.sub-content.product-detail-info.product-detail-meta.inner.sticky-on-scroll.semi-sticky > div > div.product-item-buttons > div.product-button-wrapper > button > span")).isDisplayed();
        //Thread.sleep(3000);
        //System.out.println("notStock");
        //System.out.println(notStock);
        /*
        if(notStock){
            System.out.println("No stock");
        }
        */
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
    /*
    public void incrementQuantity(){
        Bag=webDriver.findElement(By.cssSelector("body > header > nav > ul.menu__session > li.menu__session__item.shopping-bag.rollover-popdown.is-loaded"));
        Bag.click();
        quanityBag=webDriver.findElement(By.className("Select-module--select__5Uzpn"));
        quanityBag.click();
    }
    */
}
