package app;

import app.classes.EditorWidget;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Start function wil run when application is run/initialised
     * @param primaryStage is the window itself
     * @throws Exception is what this function will throw if there is an error
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set root window structure as border pane
        BorderPane root = new BorderPane();

        // Vertical Box to hold elements stacked vertically
        VBox verticalBox = new VBox();
        // Set all elements inside vertical box that need to be stacked top down
        verticalBox.getChildren().addAll(
                EditorWidget.menuToolBar(root, primaryStage),
                // EditorWidget.editingToolBar(root),
                EditorWidget.editor(root),
                EditorWidget.statsFooter(root)
        );
        // Set vertical box to top of border pane
        root.setTop(verticalBox);

        // ---------- Set Stylesheets
        root.getStylesheets().addAll(
                getClass().getResource("assets/StatsToolbar.css").toExternalForm(),
                getClass().getResource("assets/MenuToolbar.css").toExternalForm(),
                getClass().getResource("assets/EditingToolBar.css").toExternalForm()
        );

        // Configure window
        primaryStage.setTitle("Smash Editor");
        primaryStage.getIcons().add(new Image(getClass().getResource("assets/images/smashEditorLogo.png").toExternalForm()));
        primaryStage.setScene(new Scene(root, 700, 504));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
