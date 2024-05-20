package pt.isec.pa.exerc29.ui.gui;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import pt.isec.pa.exerc29.model.ModelManager;
import pt.isec.pa.exerc29.utils.AppLog;

import javafx.event.ActionEvent;

public class RootPane extends BorderPane {
    private static final String LINE = "Line";
    private static final String RECT = "Rect";
    private static final String ELLIPSE = "Ellipse";

    ModelManager model;
    Pane centralPane;
    ToggleGroup tgr;
    ToggleButton tbtOpt1, tbtOpt2, tbtOpt3;

    public RootPane(ModelManager model) {
        this.model = model;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        HBox hbox = new HBox();
        tgr = new ToggleGroup();
        tbtOpt1 = new ToggleButton(LINE);
        tbtOpt1.setToggleGroup(tgr);
        tbtOpt1.setPrefWidth(Integer.MAX_VALUE);
        tbtOpt2 = new ToggleButton(RECT);
        tbtOpt2.setToggleGroup(tgr);
        tbtOpt2.setPrefWidth(Integer.MAX_VALUE);
        tbtOpt3 = new ToggleButton(ELLIPSE);
        tbtOpt3.setToggleGroup(tgr);
        tbtOpt3.setPrefWidth(Integer.MAX_VALUE);
        tgr.selectToggle(tbtOpt1);
        hbox.getChildren().addAll(tbtOpt1, tbtOpt2, tbtOpt3);
        this.setTop(hbox);
        centralPane = new Pane();
        setCenter(centralPane);
    }

    private void registerHandlers() {
        tbtOpt1.setOnAction((ActionEvent evt) -> {
            AppLog.getInstance().add(LINE);
            update();
        });
        tbtOpt2.setOnAction((ActionEvent evt) -> {
            AppLog.getInstance().add(RECT);
            update();
        });
        tbtOpt3.setOnAction((ActionEvent evt) -> {
            AppLog.getInstance().add(ELLIPSE);
            update();
        });
        centralPane.setOnMousePressed(evt -> {
            model.setP1(evt.getX(), evt.getY());
            model.setP2(evt.getX(), evt.getY());
            model.defineColor();
            model.setToFill(evt.isAltDown());
            update();
        });


        centralPane.setOnMouseDragged(evt -> {
            model.setP2(evt.getX(), evt.getY());
        });

        centralPane.setOnMouseClicked(evt -> {
            AppLog.getInstance().add(
                    String.format("x:%.2f y:%.2f Shift:%b Ctrl:%b Alt:%b",
                            evt.getX(), evt.getY(), evt.isShiftDown(), evt.isControlDown(), evt.isAltDown()
                    )
            );
        });
    }

    private void update() {
        //centralPane.getChildren().clear();
        Shape shape = null;
        if (tbtOpt1.isSelected()) {
            shape = new Line(model.getX1(),model.getY1(),model.getX2(),model.getY2());
        }
        else if (tbtOpt2.isSelected()) {
            shape = new Rectangle(model.getX1(),model.getY1(),model.getX2(),model.getY2());
        }else{
            shape = new Ellipse();
        }
        if (shape == null){
            return;
        }
        Color color = Color.color(model.getR(), model.getG(), model.getB());
        Color strokeColor = color.darker();
        //shape.setFill(model.setToFill(););
        /*var line = new Line(50,50,200,100);
        var rect = new Rectangle(250,50,100,50);
        var elip = new Ellipse(225,175,75,50);
        line.setStroke(Color.INDIGO);
        rect.setStroke(Color.INDIGO);
        elip.setStroke(Color.INDIGO);
        if (tbtOpt1.isSelected()) {
            rect.setFill(null);
            elip.setFill(null);
        } else if (tbtOpt2.isSelected()) {
            rect.setFill(Color.ORANGE);
            elip.setFill(Color.ORANGE);
        } else if (tbtOpt3.isSelected()) {
            rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            elip.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        }*/
        centralPane.getChildren().addAll(line, rect, elip);
    }
}
