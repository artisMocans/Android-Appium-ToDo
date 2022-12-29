package StepImplementations;

import Config.ConstantConfig;
import Screens.CommonScreen;
import Screens.HomeScreen;
import Steps.DeleteNoteSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import java.util.List;

public class DeleteNoteAndroidImplementation extends CommonScreen implements DeleteNoteSteps {

    private final HomeScreen homeScreen;

    public DeleteNoteAndroidImplementation(AppiumDriver driver) {
        super(driver);
        homeScreen = new HomeScreen(driver);
    }

    @Override
    public void tapMoreButton() {
        waitUtils.waitAndClickElement(homeScreen.moreButton);
    }

    @Override
    public void tapDeleteAllButton() {
        waitUtils.waitForElementToBeVisible(By.className("android.widget.ListView"));

        List<MobileElement> titleList = driver.findElements(By.id("title"));
        MobileElement desiredTitleElement = titleList.stream()
                .filter(element -> element.getText().equals(ConstantConfig.DELETE_ALL_BUTTON_TITLE))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Couldn't find element with text: " + ConstantConfig.DELETE_ALL_BUTTON_TITLE));
        desiredTitleElement.click();
    }

    @Override
    public void tapYesButton() {
        waitUtils.waitAndClickElement(homeScreen.yesButton);
    }

    @Override
    public boolean isNoteDeleted() {
        return isElementPresent(By.id("constraint_layout_item_container"));
    }
}
