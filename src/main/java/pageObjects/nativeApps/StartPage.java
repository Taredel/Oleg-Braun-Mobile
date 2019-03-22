package pageObjects.nativeApps;

import enums.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StartPage {

    private AppiumDriver driver;

    public StartPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.android.contactmanager:id/addContactButton")
    private AndroidElement contactButton;

    @AndroidFindBy(id = "android:id/title")
    private RemoteWebElement pageTitle;

    public void addContact() {
        assertTrue(contactButton.isDisplayed());
        contactButton.click();
    }

    public void checkTitle(Constants title) {
        assertEquals(this.pageTitle.getText(), title.value);
    }
}
