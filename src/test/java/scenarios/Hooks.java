package scenarios;

import enums.PropertyFiles;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import static enums.PropertyFiles.NATIVE;
import static enums.PropertyFiles.WEB;

@Test(groups = {"native", "web"})
public class Hooks extends Driver {

    private PropertyFiles currentProperties;


    /**
     * Setup properties depending on the type of application
     *
     * @param currentProperties
     */
    public Hooks(PropertyFiles currentProperties) {
        this.currentProperties = currentProperties;
    }

    @BeforeSuite(description = "Prepare native driver to run test")
    public void setUp() throws Exception {
        setPropertyFile(currentProperties);
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion", alwaysRun = true)
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
