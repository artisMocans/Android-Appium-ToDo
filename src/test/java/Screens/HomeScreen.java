package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends CommonScreen{

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "addBtn")
    public MobileElement addButton;

    @AndroidFindBy(id = "constraint_layout_item_container")
    public MobileElement noteContainer;

    @AndroidFindBy(id = "tv_item_title")
    public MobileElement noteTitle;

    @AndroidFindBy(id = "tv_item_description")
    public MobileElement noteDescription;

    @AndroidFindBy(accessibility = "More options")
    public MobileElement moreButton;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement yesButton;
}
