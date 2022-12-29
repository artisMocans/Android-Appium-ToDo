package Screens;


import Utils.PropertyUtils;
import Utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CommonScreen {

    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
    public WaitUtils waitUtils;
    protected final AppiumDriver driver;

    protected CommonScreen(AppiumDriver driver) {
        this.driver = driver;
        initElements();
        loadProperties();
        waitUtils = new WaitUtils();
    }

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(IMPLICIT_WAIT)), this);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void loadProperties() {
        //TODO: Add the properties.
    }
}