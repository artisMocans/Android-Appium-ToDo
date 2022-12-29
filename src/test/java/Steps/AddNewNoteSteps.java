package Steps;

public interface AddNewNoteSteps {
    void tapAddButton();
    void setTitleTo(String title);
    void setDescriptionTo(String description);
    void setPriorityTo(String priority);
    void tapAddNewNoteButton();
    boolean isNewNoteAdded();
}