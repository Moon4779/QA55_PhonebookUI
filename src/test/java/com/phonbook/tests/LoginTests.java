package com.phonbook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
public void ensurePrecondition(){
    if(!app.getUser().isLoginPresent()){
        app.getUser().clickOnSignOutButton();
    }
}
    @Test
    public void loginPositiveTests(){
        logger.info("Login with data-->" + UserData.EMAIl+"*****************"+UserData.PASSWORD);
        // click on login link
        app.getUser().clickOnLoginLink();
        // enter email to email field
        app.getUser().fillRegistrationLoginForm(new User().setEmail(UserData.EMAIl).setPassword(UserData.PASSWORD));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutButtonPresent());


    }

    @Test
    public void loginNegativeWithoutEmailTests(){
        // click on login link
        app.getUser().clickOnLoginLink();
        // enter email to email field
        app.getUser().fillRegistrationLoginForm(new User().setPassword(UserData.PASSWORD));

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertDisplayed());


    }

}
