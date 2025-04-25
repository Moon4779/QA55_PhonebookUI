package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void ClickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillRegistrationLoginForm(User user) {
        type(By.name("email"), user.getEmail());

        // enter email to email field
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }

    public boolean isLoginPresent() {
        return  isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }
}
