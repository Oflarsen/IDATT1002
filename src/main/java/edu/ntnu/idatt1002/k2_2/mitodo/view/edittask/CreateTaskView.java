package edu.ntnu.idatt1002.k2_2.mitodo.view.edittask;

import edu.ntnu.idatt1002.k2_2.mitodo.data.project.Project;

import edu.ntnu.idatt1002.k2_2.mitodo.util.SoundEffects;
import edu.ntnu.idatt1002.k2_2.mitodo.view.View;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class CreateTaskView extends EditOrCreateTaskView
{
    public void setProject(Project project)
    {
        Platform.runLater(() -> taskName.requestFocus());
        this.project = project;
        selectProject.setValue(project);
    }

    @FXML
    protected void saveAndExit()
    {
        try
        {
            this.task = project.addTask(taskName.getText());
            super.saveAndExit();
        }
        catch(IllegalArgumentException e)
        {
            SoundEffects.playErrorSound();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error: " + e.getMessage());
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
    }

    @Override
    public String getMainMenuTitle()
    {
        return "Create Task";
    }

    @Override
    public boolean equals(View view)
    {
        return view instanceof EditTaskView;
    }
}
