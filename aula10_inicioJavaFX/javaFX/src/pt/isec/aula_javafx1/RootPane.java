package pt.isec.aula_javafx1;

import com.sun.glass.events.DndEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.aula_javafx1.data.ModelData;

import java.util.EventListener;


public class RootPane extends BorderPane { //View-Controller
    Color background = Color.BLACK;
    int nrGreen,nrBlue,nrOther;

    Button btnGreen;
    Button btnBlue;
    TextField tfColor;
    Button CustomColor;
    Label lbStatus;

    ModelData data;


    // variables, including reference to views
    //public RootPane(ModelData data)
    public RootPane(){
        this.data = data;
        createViews();
        registerHandlers();
        update();
    }
    private void createViews() {
        btnBlue = new Button("Blue");
        btnGreen = new Button("Green");
        tfColor = new TextField();
        CustomColor = new Button("set color");
        tfColor.setPromptText("color name or RGB");
        //tfColor.setPrefWidth(Integer.MAX_VALUE);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnBlue,btnGreen,tfColor,CustomColor);
        hbox.setSpacing(10);
        this.setTop(hbox);
        lbStatus = new Label("riudghgdiuhgd");

        this.setBottom(lbStatus);
    }
    private void registerHandlers() {
        btnGreen.setOnAction(actionEvent -> {
            nrGreen++;
            background = Color.GREEN;
            update();
        });
        btnBlue.setOnAction(actionEvent -> {
            nrBlue++;
            background = Color.BLUE;
            update();
        });
        tfColor.setOnAction(actionEvent -> {
            nrOther++;
            try{
                background = Color.valueOf(tfColor.getText());
            }catch (Exception e){
                background = Color.BLACK;
                tfColor.setStyle("-fx-control-inner-background: #ff0000;");
                tfColor.requestFocus();
            }
            update();
        });

        tfColor.setOnKeyPressed(keyEvent -> { //está incompleto mas entende-se
            tfColor.setStyle("-fx-control-inner-background: #ffffff;");

            //if(keyEvent.getCode() == KeyCode.ENTER){
            //    CustomColor
            //}
        });

    }
    private void update() {
        this.setBackground(new Background(new BackgroundFill(background,CornerRadii.EMPTY, Insets.EMPTY))); // corner radii torna as bordas arredondadas;  o insets é para deixar uma borda não pintada
        //lbStatus.setText(String.format("Green: %d \t Blue: %d \t Other: %d",nrGreen,nrBlue,nrOther));
    }
}