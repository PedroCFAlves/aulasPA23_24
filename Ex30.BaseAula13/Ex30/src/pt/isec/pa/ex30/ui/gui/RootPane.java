package pt.isec.pa.ex30.ui.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pt.isec.pa.ex30.model.DrawingManager;

public class RootPane extends BorderPane {
    DrawingManager drawing;
    DrawingArea drawingArea;
    Pane areaPane;

    public RootPane(DrawingManager drawing) {
        this.drawing = drawing;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        setTop(
                new VBox(
                        new DrawingMenu(drawing),
                        new DrawingToolBar(drawing)
                )
        );

        drawingArea = new DrawingArea(drawing);
        areaPane = new Pane(drawingArea);
        setCenter(areaPane);
    }

    private void registerHandlers() {
        areaPane.widthProperty().addListener(observable -> drawingArea.updateSize(areaPane.getWidth(), areaPane.getHeight()));
        areaPane.heightProperty().addListener(observable -> drawingArea.updateSize(areaPane.getWidth(), areaPane.getHeight()));
    }

    private void update() {
    }
}
