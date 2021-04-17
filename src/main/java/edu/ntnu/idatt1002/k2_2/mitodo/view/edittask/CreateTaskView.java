package edu.ntnu.idatt1002.k2_2.mitodo.view.edittask;

import edu.ntnu.idatt1002.k2_2.mitodo.data.Project;
import javafx.fxml.FXML;

public class CreateTaskView extends EditOrCreateTaskView
{
    public void setProject(Project project)
    {
        this.project = project;
    }

    @FXML
    protected void saveAndExit()
    {
        this.task = project.addTask("My task");
        super.saveAndExit();
    }
}
