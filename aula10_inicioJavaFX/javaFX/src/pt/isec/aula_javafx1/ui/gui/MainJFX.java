package pt.isec.aula_javafx1.ui.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pt.isec.aula_javafx1.RootPane;
import pt.isec.aula_javafx1.data.ModelData;

public class MainJFX extends Application {
    //ModelData data;
    //public MainJFX() { data = new ModelData(); } // It can also be created in 'init'
    @Override
    public void start(Stage stage) throws Exception {
        RootPane root = new RootPane();
        //Pane root = new BorderPane();
        Scene scene = new Scene(root,600,400);
        stage.setMinHeight(500);
        stage.setMinWidth(500);

        stage.setScene(scene);
        stage.setTitle("ColorButtons");
        stage.show();
    }
}
