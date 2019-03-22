package pageObjects.nativeApps;

import enums.Constants;
import enums.UserDataTypes;
import enums.Users;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactPage {

    private AppiumDriver driver;

    public ContactPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/title")
    private RemoteWebElement pageTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Save\"]")
    private RemoteWebElement saveButton;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    private RemoteWebElement contactNameField;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    private RemoteWebElement contactPhoneField;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneTypeSpinner")
    private RemoteWebElement contactPhoneTypeField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]//android.widget.TableRow[6]//android.widget.TextView")
    private RemoteWebElement contactPhoneTypeFieldText;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.ListView/*")
    private List<RemoteWebElement> types;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    private RemoteWebElement contactEmailField;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailTypeSpinner")
    private RemoteWebElement contactEmailTypeField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]//android.widget.TableRow[8]//android.widget.TextView")
    private RemoteWebElement contactEmailTypeFieldText;

    public void checkButtonExist(Constants button) {
        assertTrue(saveButton.isDisplayed());
        assertEquals(saveButton.getText(), button.value);
    }

    public void checkTitle(Constants title) {
        assertEquals(this.pageTitle.getText(), title.value);
    }

    public void removeKeyboard() {
        driver.hideKeyboard();
    }

    public void sumbit() {
        saveButton.click();
    }

    public void createNewContact(Users user, UserDataTypes phoneType, UserDataTypes emailType) {
        contactNameField.click();
        contactNameField.sendKeys(user.getContactName());
        fillPhone(user, phoneType);
        fillEmail(user, emailType);
    }

    public void checkContactData(Users user, UserDataTypes phoneType, UserDataTypes emailType) {
        assertEquals(contactNameField.getText(), user.getContactName());
        assertEquals(contactPhoneField.getText(), user.getContactPhone());
        assertEquals(contactEmailField.getText(), user.getContactEmail());
        assertEquals(contactPhoneTypeFieldText.getText(), phoneType.label);
        assertEquals(contactEmailTypeFieldText.getText(), emailType.label);
    }

    private void fillPhone(Users user, UserDataTypes phoneType) {
        contactPhoneField.click();
        contactPhoneField.sendKeys(user.getContactPhone());
        contactPhoneTypeField.click();
        for (RemoteWebElement type : types) {
            if (type.getText().equals(phoneType.label)) {
                type.click();
                break;
            }
        }
        removeKeyboard();
    }

    private void fillEmail(Users user, UserDataTypes emailType) {
        contactEmailField.click();
        contactEmailField.sendKeys(user.getContactEmail());
        contactEmailTypeField.click();
        for (RemoteWebElement type : types) {
            if (type.getText().equals(emailType.label)) {
                type.click();
                break;
            }
        }
        removeKeyboard();
    }
}