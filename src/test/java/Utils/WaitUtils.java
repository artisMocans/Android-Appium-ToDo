package Utils;

import StepDefinitions.TestRunHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitUtils {
    private final TestRunHelper testRunHelper = new TestRunHelper();
    public final int explicitWaitDefault = PropertyUtils.getIntegerProperty("explicitWait", 60);

    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }

    public void waitForElementToBeClickable(final MobileElement element) {
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeInvisible(final By locator) {
        long s = System.currentTimeMillis();
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementToBePresent(final By locator) {
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(final By locator) {
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(final MobileElement element) {
        long s = System.currentTimeMillis();
        CustomLogger.log.setLevel(Level.DEBUG);
        CustomLogger.log.debug("Waiting for element: "+ element.toString() + " to be displayed...");
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeVisible(final MobileElement element, int timeInSeconds) {
        long s = System.currentTimeMillis();
        CustomLogger.log.setLevel(Level.DEBUG);
        CustomLogger.log.debug("Waiting for element: "+ element.toString() + " to be displayed...");
        new WebDriverWait(testRunHelper.getDriver(), timeInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForElementAndAssert(final MobileElement element) {
        long s = System.currentTimeMillis();
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void waitAndClickElement(final MobileElement element) {
        long s = System.currentTimeMillis();
        CustomLogger.log.setLevel(Level.DEBUG);
        CustomLogger.log.debug("Waiting for element: "+ element.toString() + " to be displayed...");
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault).until(ExpectedConditions.visibilityOf(element));
        CustomLogger.log.debug("Element: "+ element + " is visible, clicking element...");
        element.click();
    }

    public void waitForElementToBeVisible(final IOSElement element, int timeInSeconds) {
        long s = System.currentTimeMillis();
        new WebDriverWait(testRunHelper.getDriver(), timeInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsToBeInvisible(final List<WebElement> elements) {
        final long s = System.currentTimeMillis();
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault)
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void waitForElementToBeNotPresent(final By element) {
        long s = System.currentTimeMillis();
        new WebDriverWait(testRunHelper.getDriver(), this.explicitWaitDefault)
                .until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(element)));
    }

    public void waitUntilNestedElementPresent(MobileElement element, By locator) {
        new WebDriverWait(testRunHelper.getDriver(), explicitWaitDefault)
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }
}