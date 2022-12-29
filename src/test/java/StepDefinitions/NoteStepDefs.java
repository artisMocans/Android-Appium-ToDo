package StepDefinitions;

import Config.ConstructorHelper;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class NoteStepDefs extends ConstructorHelper {

    private final TestRunHelper testRunHelper = new TestRunHelper();
    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = testRunHelper.setupDriver("android");
        instantiateConstructors();
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        testRunHelper.tearDownAppium(driver);
    }


    @Given("user taps add button")
    public void userTapsAddButton() {
        addNewNoteSteps.tapAddButton();
    }

    @And("user fills title field with {string}")
    public void userFillsTitleFieldWith(String title) {
        addNewNoteSteps.setTitleTo(title);
    }

    @And("user sets priority to {string}")
    public void userSetsPriorityTo(String priority) {
        addNewNoteSteps.setPriorityTo(priority);
    }

    @And("user fills description field with {string}")
    public void userFillsDescriptionFieldWith(String description) {
        addNewNoteSteps.setDescriptionTo(description);
    }

    @And("user taps add new note button")
    public void userTapsAddNewNoteButton() {
        addNewNoteSteps.tapAddNewNoteButton();
    }

    @Then("new note is added")
    public void newNoteIsAdded() {
        assertTrue(addNewNoteSteps.isNewNoteAdded());
    }

    @Given("user creates new note with title {string} and description {string} and priority {string}")
    public void userCreatesNewNoteWithTitleAndDescriptionAndPriority(String title, String description, String priority) {
        addNewNoteSteps.tapAddButton();
        addNewNoteSteps.setTitleTo(title);
        addNewNoteSteps.setPriorityTo(priority);
        addNewNoteSteps.setDescriptionTo(description);
        addNewNoteSteps.tapAddNewNoteButton();
        assertTrue(addNewNoteSteps.isNewNoteAdded());
    }

    @And("user taps more button")
    public void userTapsMoreButton() {
        deleteNoteSteps.tapMoreButton();
    }

    @And("user taps Delete all button")
    public void userTapsDeleteAllButton() {
        deleteNoteSteps.tapDeleteAllButton();
    }

    @When("user taps yes button")
    public void userTapsYesButton() {
        deleteNoteSteps.tapYesButton();
    }

    @Then("note is deleted")
    public void noteIsDeleted() {
        assertFalse(deleteNoteSteps.isNoteDeleted());
    }
}
