package com.phonbook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactsTests extends TestBase  {
    @BeforeMethod
    public void precondotion(){
        if(!app.getUser().isLoginPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        // enter email to email field
        app.getUser().fillRegistrationLoginForm(new User().setEmail(UserData.EMAIl).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getContact().ClickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.Name)
                .setLastName(ContactData.Last_Name)
                .setPhone(ContactData.Phone)
                .setEmail(ContactData.Email)
                .setAddress(ContactData.Adress)
                .setDescription(ContactData.Description));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactsTests(){
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deliteContact();
        app.getContact().pause(3000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1);
    }

}
