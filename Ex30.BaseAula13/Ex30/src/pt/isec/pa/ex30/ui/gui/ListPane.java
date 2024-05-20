package pt.isec.pa.ex30.ui.gui;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.isec.pa.ex30.model.DrawingManager;
import pt.isec.pa.ex30.model.data.Figure;
//mport javafx.geometry.Pos;
public class ListPane extends ListView<Figure> {
    DrawingManager drawing;
    //ContextMenu ContextMenu;
    MenuItem delete,change;
    public ListPane(DrawingManager drawing) {
        this.drawing = drawing;
        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        delete = new MenuItem("Delete");
        change = new MenuItem("Change color");
        this.setContextMenu(
                new ContextMenu(delete,change)
        );
    }




    private void registerHandlers() {
        drawing.addPropertyChangeListener(DrawingManager.PROP_FIGURES,
                evt -> update());
        this.setOnMouseClicked( mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) { // double-click
                drawing.remove(this.getSelectionModel().getSelectedIndex());
            }
        });
        delete.setOnAction(
                actionEvent ->
                        drawing.remove(
                                this.getSelectionModel()
                                        .getSelectedIndex()
                        )
        );

        change.setOnAction( actionEvent -> {
            Stage dlg = new Stage();
            Label lbl = new Label("Change to a random color");
            Button changeBtn = new Button("Ok");
            changeBtn.setOnAction(evt -> {
                /*Figure figure = this.getSelectionModel().getSelectedItem();
                if (figure==null)
                    return;
                Figure.FigureType oldType = drawing.getCurrentType();
                drawing.remove(this.getSelectionModel().getSelectedIndex());
                drawing.setRGB(Math.random(),Math.random(),Math.random());
                drawing.setCurrentType(figure.getType());
                drawing.createFigure(figure.getX1(),figure.getY1());
                drawing.finishCurrentFigure(figure.getX2(),figure.getY2());
                drawing.setCurrentType(oldType);*/
                int selectedIndex = this.getSelectionModel().getSelectedIndex();
                if (selectedIndex >=0)
                    drawing.setFigureRGB(selectedIndex,Math.random(),Math.random(),Math.random());

                dlg.close();
// TODO: (Homework) Modify the model to allow changes to figure properties (xi,yi,xf,yf,r,g,b)
            });
            VBox rootPane = new VBox(lbl,changeBtn);
            //rootPane.setAlignment(Pos.CENTER);
            Scene scene = new Scene(rootPane,200,60);
            dlg.setScene(scene);
            dlg.initModality(Modality.APPLICATION_MODAL);
            dlg.initOwner(this.getScene().getWindow());
            dlg.setAlwaysOnTop(true);
            dlg.showAndWait();
        });


        
    }

    private void update() {
        this.getItems().clear();
        this.getItems().addAll(drawing.getList());
    }
}
