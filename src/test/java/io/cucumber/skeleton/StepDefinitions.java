package io.cucumber.skeleton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.skeleton.Pages.AddInCart;
import io.cucumber.skeleton.Pages.HomePage;
import io.cucumber.skeleton.Pages.Login;
import io.cucumber.skeleton.Pages.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StepDefinitions {
    HomePage page=new HomePage();
    Login login=new Login();
    User user;
    @Given("I opened the browser at Springfield page")
    public void i_opened_the_browser_at_Springfield_page() {
        // Write code here that turns the phrase above into concrete actions
        page.openSpringfieldURL();
        //throw new io.cucumber.java.PendingException();
    }
    @When("I look for {string} and select any displayed result to go to the shopping cart")
    public void i_look_for_and_select_any_displayed_result_to_go_to_the_shopping_cart(String string) throws InterruptedException {
        page.findProduct(string);
        page.chooseProduct(string);
        page.selectSize();
        page.addToCart();
    }
    @Then("the shopping cart show the product is not {string}")
    public void the_shopping_cart_show_the_product_is_not(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I buy {string} first products from {string}")
    public void iBuyNFirstProductsFromString(String arg0, String arg2) {
        page.findProduct(arg2);
        for(int i = 0; i<Integer.parseInt(arg0); i++){
            page.buyProduct(i);
        }
    }

    @Then("the shopping cart value is {string}")
    public void theShoppingCartValueIs(String arg0) {
        assert page.checkCartValue(Double.parseDouble(arg0));
    }

    @Then("the shopping cart value is not {string}")
    public void theShoppingCartValueIsNot(String v) {
        assert !page.checkCartValue(Double.parseDouble(v));
    }

    @When("I go to menu item {string}")
    public void iGoToMenuItem(String s) {
        page.go_toMenuItem(s);
    }

    @And("i go home")
    public void iGoHome() {
        page.go_home();
    }

    @Then("we are in home page")
    public void weAreInHomePage() {
        page.isHome();
    }

    @Given("I are user")
    public void i_are_user() throws InterruptedException {
        user=new User("nuriamba17@gmail.com","Creacontra1");
    }
    @When("I make login with incorrect user")
    public void i_make_login_with_incorrect_user() throws InterruptedException {
        user.setUser("arnaumayoral@gmail.com");
        login.login(user);
    }
    @Then("the login is not successfull")
    public void the_login_is_not_successfull() throws InterruptedException {
        boolean isLog= login.isLogged();
        assertEquals(false,isLog);
    }
    @When("I make login with incorrect password")
    public void i_make_login_with_incorrect_password() throws InterruptedException {
        user.setPass("Incorrecta");
        login.login(user);
    }

    @When("I make login with correct user and password")
    public void i_make_login_with_correct_user_and_password() {
        // Write code here that turns the phrase above into concrete actions
        boolean userCorrect=user.getUser().equals("nuriamba17@gmail.com");
        boolean passCorrect=user.getPass().equals("Creacontra1");
        System.out.println("User is correct:" + userCorrect);
        System.out.println("Password is correct:" + passCorrect);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the login is successfull")
    public void the_login_is_successfull() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        login.login(user);
        //throw new io.cucumber.java.PendingException();
    }

    @When("I create a new account with mail: {string} and pass {string}")
    public void iCreateANewAccountWithUserKevinAndPassPasswd(String arg0, String arg1) {
        page.register(arg0,arg1);
    }

    @Then("the register is successfull")
    public void theRegisterIsSuccessfull() throws InterruptedException {
        assert login.isLogged();
    }

    @When("look for a shop in {string}")
    public void lookForAShopInSabadell(String city) {
        page.go_to_find_shop(city);
    }

    @Then("{string} is found")
    public void cityIsFound(String arg0) {
        assert page.city_found(arg0);
    }
    @Then("{string} is not found")
    public void cityIsNotFound(String arg0) {
        assert !page.city_found(arg0);
    }

    @When("I logout")
    public void iLogout() throws InterruptedException {
        login.logout();
    }

    @Then("im not logged")
    public void imNotLogged() throws InterruptedException {
        assert login.isLogged();
    }

    @Then("im already out")
    public void imAlreadyOut() {
        assert login.alreadyout();
    }

    @Then("the register is not successfull")
    public void theRegisterIsNotSuccessfull() {
        assert !page.registerSuccess();
    }


    @And("I add {string} product from {string} to favorites")
    public void iAddAProductToFavorites(String i, String search) {
        page.findProduct(search);
        page.addFavorite(Integer.parseInt(i));
    }

    @Then("there are {string} items in favorites")
    public void thereAreXItemsInFavorites(String arg0) {
        int n = page.getNFavs();
        assertEquals(Integer.parseInt(arg0), n);
    }

    @Then("there are not {string} items in favorites")
    public void thereArenTItemsInFavorites(String arg0) {
        int n = page.getNFavs();
        assertNotEquals(Integer.parseInt(arg0), n);
    }
}

