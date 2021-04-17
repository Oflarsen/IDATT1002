package edu.ntnu.idatt1002.k2_2.mitodo.view.components;

import edu.ntnu.idatt1002.k2_2.mitodo.Client;
import edu.ntnu.idatt1002.k2_2.mitodo.data.PriorityEnum;
import edu.ntnu.idatt1002.k2_2.mitodo.data.RepeatEnum;
import edu.ntnu.idatt1002.k2_2.mitodo.effects.SoundEffects;
import edu.ntnu.idatt1002.k2_2.mitodo.view.edittask.EditTaskView;
import edu.ntnu.idatt1002.k2_2.mitodo.data.Task;
import edu.ntnu.idatt1002.k2_2.mitodo.view.View;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;

public class TaskInProject extends View
{
    @FXML
    private BorderPane parent;
    @FXML
    private CheckBox isDoneCheckBox;
    @FXML
    private Label priorityLabel;
    @FXML
    private Label startDateLabel;
    @FXML
    private Label dueDateLabel;
    @FXML
    private Label repeatLabel;
    @FXML
    private Label projectNameLabel;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private Task task;
    private View view;

    @FXML
    private void initialize()
    {
        setButtonImage(editButton, "editImage.png");
        setButtonImage(deleteButton, "deleteImage.png");
    }

    public void setTask(Task task)
    {
        this.task = task;
        setInfo();
    }

    public void setView(View view)
    {
        this.view = view;
    }

    private void setButtonImage(Button button, String imageFileName)
    {
        URL deleteImageUrl = getClass().getResource("/images/" + imageFileName);
        ImageView image = new ImageView(deleteImageUrl.toExternalForm());
        image.setFitHeight(25);
        image.setFitWidth(25);
        button.setGraphic(image);
    }

    @FXML
    private void handleTaskIsDoneButtonClick()
    {
        task.toggleIsDone();
        if(task.isDone())
        {
            SoundEffects.playPlingSound();
        }
        view.update();
    }

    @FXML
    private void handleEditTaskButtonClick()
    {
        EditTaskView editTaskView = (EditTaskView) Client.setView("EditTaskView");
        editTaskView.setTask(task);
    }

    @FXML
    private void handleDeleteTaskButtonClick()
    {
        task.deleteItself();
        view.update();
    }

    private void setInfo()
    {
        isDoneCheckBox.setSelected(task.isDone());
        isDoneCheckBox.setText(task.getTitle());
        priorityLabel.setText(task.getPriority() == PriorityEnum.Undefined? "" : task.getPriority() + " Priority");
        startDateLabel.setText(task.getStartDateAsString());
        dueDateLabel.setText(task.getDueDateAsString());
        repeatLabel.setText(task.getRepeat() == RepeatEnum.DoesNotRepeat? "" : "Repeats " + task.getRepeat().toString());
        projectNameLabel.setText(task.getProject().getTitle());
    }

    public Node getParent()
    {
        return parent;
    }
}
