import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     *                  retangle
     *             grid
     *      scene
     * stage
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GridPane Experiment");
        GridPane gridPane = new GridPane();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

                Field field = new Field(x, y);
                gridPane.add(field, x, y);
                Controller.getInstance().addField(field);
            }
        }

        Scene scene = new Scene(gridPane, 8 * Configurations.SIDE_SIZE, 8 * Configurations.SIDE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}