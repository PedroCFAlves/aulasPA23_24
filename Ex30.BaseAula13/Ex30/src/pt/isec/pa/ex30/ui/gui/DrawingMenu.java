package pt.isec.pa.ex30.ui.gui;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCodeCombination;
import javafx.stage.FileChooser;
import pt.isec.pa.ex30.model.DrawingManager;

import java.io.File;


public class DrawingMenu extends MenuBar {
    DrawingManager drawing;
    Menu mnFile;
    MenuItem mnNew,mnOpen,mnSave, mnExit;
     Menu mnEdit;
    MenuItem mnUndo, mnRedo;

    public DrawingMenu(DrawingManager drawing) {
        this.drawing = drawing;
        createViews();
        registerHandlers();
        update();
    }
    private void createViews() {



        mnFile = new Menu("File");
        mnNew = new MenuItem("_New");
        mnOpen = new MenuItem("_Open");
        //mnOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCodeCombination.CONTROL_DOWN));
        mnSave = new MenuItem("_Save");
        mnExit = new MenuItem("_Exit");
        mnFile.getItems().addAll(mnNew,mnOpen,mnSave, new SeparatorMenuItem(),mnExit);
        mnEdit = new Menu("Edit");

        mnUndo = new MenuItem("_Undo");
        mnRedo = new MenuItem("_Redo");
        mnEdit.getItems().addAll(mnUndo,mnRedo);

        this.getMenus().addAll(mnFile,mnEdit);
    }
    private void registerHandlers() {

        mnNew.setOnAction(e ->
                drawing.clearAll()
        );
        mnExit.setOnAction(e->
                Platform.exit()
        );

        mnOpen.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("File open...");
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Drawing (*.dat)", "*.dat"),
                    new FileChooser.ExtensionFilter("All", "*.*")
            );
            File hFile = fileChooser.showOpenDialog(this.getScene().getWindow());
            if (hFile != null) {
                drawing.load(hFile);
            }
        });


        mnSave.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("File save...");
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Drawing (*.dat)", "*.dat"),
                    new FileChooser.ExtensionFilter("All", "*.*")
            );
            File hFile = fileChooser.showSaveDialog(this.getScene().getWindow());
            if (hFile != null) {
                drawing.save(hFile);
            }
        });

    }//necessita de se registar para observar

        private void update() {
        mnUndo.setDisable(true);
        mnRedo.setDisable(true);


    }
}