package scenarios.nativeTests;

import enums.PropertyFiles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.nativeApps.ContactPage;
import pageObjects.nativeApps.StartPage;
import scenarios.Hooks;

import static enums.Constants.*;
import static enums.UserDataTypes.*;
import static enums.Users.JACK;

@Test(groups = {"native"})
public class NativeTest extends Hooks {

    private StartPage startPage;
    private ContactPage contactPage;

    @BeforeMethod
    public void preparePageObjects() throws Exception {
        startPage = new StartPage(driver());
        contactPage = new ContactPage(driver());
    }

    //Sending proper Property File depending on the application type: NATIVE, WEB
    protected NativeTest() {
        super(PropertyFiles.NATIVE);
    }

    @Test(description = "Simple elements and functionality test of Contact Manager app")
    public void contactManagerTest() {
        //1 check start page title in app
        startPage.checkTitle(START_PAGE_TITLE);

        //2 click 'Add Contact' button
        startPage.addContact();

        //3 check title in opened page
        contactPage.checkTitle(CONTACT_PAGE_TITLE);

        //4 remove Keyboard
        contactPage.removeKeyboard();

        //5 check 'Save Button' is displayed
        contactPage.checkButtonExist(SAVE_BUTTON);

        //6 create new contact
        contactPage.createNewContact(JACK, OTHER, MOBILE);

        //7 check whether all fields are filled
        contactPage.checkContactData(JACK, OTHER, MOBILE);

        //8 submit new contact
        contactPage.sumbit();
    }
}
