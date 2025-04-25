package com.phonbook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{
    @BeforeMethod

    public void precondition(){
        if(!app.getUser().isLoginPresent()){
            app.getUser().clickOnSignOutButton();
        }
        // click on login link
        app.getUser().clickOnLoginLink();
        // enter email to email field
        app.getUser().fillRegistrationLoginForm(new User().setEmail(UserData.EMAIl).setPassword(UserData.PASSWORD));

        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTests() {
        app.getContact().ClickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.Name)
                .setLastName(ContactData.Last_Name)
                .setPhone(ContactData.Phone)
                .setEmail(ContactData.Email)
                .setAddress(ContactData.Adress)
                .setDescription(ContactData.Description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.Name));
    }

    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name,String lastName,
                                                       String phone,
                                                       String email,String address,
                                                       String description){
        app.getContact().ClickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }





     @Test(dataProvider = "addNewContactWithCvs",dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvFileTests(Contact contact){
        app.getContact().ClickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));


    }

    @AfterMethod
    public void postCondition(){

        app.getContact().deliteContact();
    }

    //login
    // click on Add link
    // enter name
    // enter lastname
    // enter phone
    // email
    // enter address
    // enter description
    // click on Save button
    // verify contact is Added
}
