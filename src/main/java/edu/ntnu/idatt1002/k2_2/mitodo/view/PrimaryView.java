package edu.ntnu.idatt1002.k2_2.mitodo.view;

import edu.ntnu.idatt1002.k2_2.mitodo.view.components.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

/**
 * The PrimaryView contains the main menu and the content.
 * The main menu can be updated and the content can be changed.
 */
public class PrimaryView extends View
{
    private Scene scene;
    private MainMenu mainMenu;

    @FXML
    private SplitPane parent;

    @FXML
    private TreeView<Label> mainMenuTreeView;

    @FXML
    private AnchorPane content;

    /**
     * Initializes the PrimaryView object.
     */
    public void initialize() {
        this.scene = new Scene(parent);
        mainMenu = new MainMenu(mainMenuTreeView);
        updateMainMenu();
    }

    /**
     * Updates the main menu.
     */
    public void updateMainMenu()
    {
        mainMenu.update();
    }

    /**
     * Sets the content to a new view.
     * @param view The view to display.
     */
    public void setContent(View view)
    {
        content.getChildren().clear();
        content.getChildren().add(view.getParent());
    }

    /**
     * @return The scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * @return The parent node.
     */
    @Override
    public Node getParent()
    {
        return parent;
    }
}
