package edu.ntnu.idatt1002.k2_2.mitodo.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class QuickTasksPage extends Page
{
    private final String PAGE_TITLE = "Quick tasks";

    @Override
    public Scene getScene()
    {
        HBox parent = new HBox();

        StackPane menu = new MainMenu(PAGE_TITLE).getMenuLayout();
        StackPane content = getContentLayout();

        parent.getChildren().addAll(menu, content);

        StackPane mainStackPane = new StackPane();
        mainStackPane.getChildren().add(parent);
        StackPane.setAlignment(parent, Pos.CENTER);

        return new Scene(mainStackPane);
    }

    public String getPageTitle()
    {
        return PAGE_TITLE;
    }

    private StackPane getContentLayout()
    {
        Label testLabel = new Label("Quick tasks content.");
        StackPane stackPane = new StackPane(testLabel);
        return stackPane;
    }
}
