package Config;


import StepDefinitions.TestRunHelper;
import StepImplementations.AddAndroidImplementation;
import StepImplementations.DeleteNoteAndroidImplementation;
import Steps.AddNewNoteSteps;
import Steps.DeleteNoteSteps;
import Utils.CustomLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Level;

public class ConstructorHelper {
    private final TestRunHelper testRunHelper = new TestRunHelper();
    private AppiumDriver driver;
    public AddNewNoteSteps addNewNoteSteps;
    public DeleteNoteSteps deleteNoteSteps;

    public void instantiateConstructors() {
        CustomLogger.log.setLevel(Level.INFO);
        driver = testRunHelper.getDriver();

        if (driver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).equals("Android")) {
            CustomLogger.log.info("Test running on Android platform, instantiating constructors for Android...");
            CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);

            addNewNoteSteps = new AddAndroidImplementation(driver);
            deleteNoteSteps = new DeleteNoteAndroidImplementation(driver);

        } else if (driver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).equals("iOS")) {
            CustomLogger.log.info("Test running on iOS platform that is currently not supported, please come back later....");
            CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);
        }
    }
}