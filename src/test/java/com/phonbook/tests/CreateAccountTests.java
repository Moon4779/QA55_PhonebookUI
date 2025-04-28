package com.phonbook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
            public void ensurePrecondition(){
        if(!app.getUser().isLoginPresent()){
            app.getUser().clickOnSignOutButton();

        }
    }
    SoftAssert softAssert=new SoftAssert();
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){

        // click on login link
        app.getUser().clickOnLoginLink();
        // enter email to email field
        app.getUser().fillRegistrationLoginForm(new User().setEmail(UserData.EMAIl).setPassword(UserData.PASSWORD));
        // enter email to email field
        app.getUser().ClickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void existedUserRegistrationNegativeTest(){

        // click on login link
        app.getUser().clickOnLoginLink();
        // enter email to email field
        app.getUser().fillRegistrationLoginForm(new User().setEmail(UserData.EMAIl).setPassword(UserData.PASSWORD));
        // enter email to email field
        app.getUser().ClickOnRegistrationButton();
        //verify Alert is displayed
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }


    // click on Registration button

    // verify SinOut button is displayed


}
