package StepImplementations;

import Screens.AddNoteScreen;
import Screens.CommonScreen;
import Screens.HomeScreen;
import Steps.AddNewNoteSteps;
import Utils.CustomLogger;
import Utils.Globals;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import java.util.List;

public class AddAndroidImplementation extends CommonScreen implements AddNewNoteSteps {

    private final HomeScreen homeScreen;
    private final AddNoteScreen addNoteScreen;
    private final Globals globals;

    public AddAndroidImplementation(AppiumDriver driver) {
        super(driver);
        homeScreen = new HomeScreen(driver);
        addNoteScreen = new AddNoteScreen(driver);
        globals = new Globals();
    }

    @Override
    public void tapAddButton() {
        waitUtils.waitAndClickElement(homeScreen.addButton);
    }

    @Override
    public void setTitleTo(String title) {
        waitUtils.waitForElementToBeVisible(addNoteScreen.titleField);
        addNoteScreen.titleField.sendKeys(title);
        globals.setNoteTitle(title);
    }

    @Override
    public void setDescriptionTo(String description) {
        waitUtils.waitForElementToBeVisible(addNoteScreen.descriptionField);
        addNoteScreen.descriptionField.sendKeys(description);
        globals.setNoteDescription(description);
    }

    @Override
    public void setPriorityTo(String priority) {
        waitUtils.waitAndClickElement(addNoteScreen.prioritiesButton);
        waitUtils.waitForElementToBeVisible(By.className("android.widget.ListView"));

        List<MobileElement> priorityList = driver.findElements(By.id("android:id/text1"));

        MobileElement desiredPriority = priorityList.stream()
                .filter(element -> element.getText().equals(priority))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Couldn't find element with text: " + priority));
        desiredPriority.click();
    }

    @Override
    public void tapAddNewNoteButton() {
        waitUtils.waitAndClickElement(addNoteScreen.addButton);
    }

    @Override
    public boolean isNewNoteAdded() {
        waitUtils.waitForElementToBeVisible(homeScreen.noteContainer);
        String expectedTitle = globals.getNoteTitle();
        String expectedDescription = globals.getNoteDescription();

        CustomLogger.log.setLevel(Level.INFO);
        CustomLogger.log.info("Expected note title: " + globals.getNoteTitle() +" | Actual note title: " + homeScreen.noteTitle.getText());
        CustomLogger.log.info("Expected note description: " + globals.getNoteDescription() +" | Actual note description: " + homeScreen.noteDescription.getText());

        return homeScreen.noteContainer.isDisplayed() && homeScreen.noteTitle.getText().equals(expectedTitle) && homeScreen.noteDescription.getText().equals(expectedDescription);
    }
}