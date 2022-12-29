package StepDefinitions;

import Config.ConstantConfig;
import Utils.CustomLogger;
import Utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Level;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRunHelper {

    private static AppiumDriver<MobileElement> driver;
    public final static String APPIUM_SERVER_URL = PropertyUtils.getProperty("appium.server.url", "http://127.0.0.1:4723/wd/hub");
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);


    public AppiumDriver<MobileElement> setupDriver(String platformName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platformName.equalsIgnoreCase("android")) {
            CustomLogger.log.setLevel(Level.INFO);
            CustomLogger.log.info("Setting up Android driver...");
            setCapabilitiesForAndroid(capabilities);
        } else if (platformName.equalsIgnoreCase("ios")) {
            CustomLogger.log.setLevel(Level.INFO);
            CustomLogger.log.info("iOS is currently not supported, come back later...");
        }
        printCapabilities(capabilities);
        return driver;
    }

    public void tearDownAppium(AppiumDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    private void setCapabilitiesForAndroid(DesiredCapabilities capabilities) throws MalformedURLException {
        String PLATFORM_NAME = PropertyUtils.getProperty("android.platform");
        String PLATFORM_VERSION = PropertyUtils.getProperty("android.platform.version");
        String DEVICE_NAME = PropertyUtils.getProperty("android.device.name");
        String APP_FULL_RESET = PropertyUtils.getProperty("android.app.full.reset");
        String APP_NO_RESET = PropertyUtils.getProperty("android.app.no.reset");
        String APP_PATH = PropertyUtils.getProperty("android.app.path");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, APP_FULL_RESET);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, APP_NO_RESET);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities);
    }

    private void printCapabilities(DesiredCapabilities capabilities) {
        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);
        CustomLogger.log.info("[ Test Configuration ] - Desired Capabilities Configuration established");
        CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);
        CustomLogger.log.info(" DEVICE PROPERTIES");
        CustomLogger.log.info("\tPlatform Name:\t\t" + capabilities.getCapability(MobileCapabilityType.PLATFORM_NAME));
        CustomLogger.log.info("\tDevice Name:\t\t" + capabilities.getCapability(MobileCapabilityType.DEVICE_NAME));
        CustomLogger.log.info("\tPlatform Version:\t\t" + capabilities.getCapability(MobileCapabilityType.PLATFORM_VERSION));
        CustomLogger.log.info("\tAutomation Engine:\t\t" + capabilities.getCapability(MobileCapabilityType.AUTOMATION_NAME));
        CustomLogger.log.info("\tNo Reset:\t\t" + capabilities.getCapability(MobileCapabilityType.NO_RESET));
        CustomLogger.log.info("\tFull Reset:\t\t" + capabilities.getCapability(MobileCapabilityType.FULL_RESET));
        CustomLogger.log.info(ConstantConfig.LOG_SEPARATOR);
    }
}