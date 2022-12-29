package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddNoteScreen extends CommonScreen{

    public AddNoteScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "ed_add_title")
    public MobileElement titleField;

    @AndroidFindBy(id = "spinner_add_priorities")
    public MobileElement prioritiesButton;

    @AndroidFindBy(id = "ed_add_description")
    public MobileElement descriptionField;

    @AndroidFindBy(accessibility = "Add")
    public MobileElement addButton;
}
