import javafx.application.Application;
//каждая штука изначально в высь 25, но надо указывать 50.1
//надо всё как то оптимизировать чтобы всякие прохождения по кнопкам, ивент хендлеры были в других методах
//можно изи кнопку сброса организовать
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;
import java.util.Random;

public class Caclulator extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
        Color[] colors=new Color[16];
        Button[] button ={new Button("7 "), new Button("8"), new Button("9"), new Button("+"),
                new Button("4"), new Button("5"), new Button("6"), new Button("-"),
                new Button("1"), new Button("2"), new Button("3"), new Button("*"),
                new Button("="), new Button("0"), new Button("."), new Button("/"),};
        int[] first = new int[1];
        int[] second =new int[1];
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem open = new MenuItem("open");
        MenuItem settings = new MenuItem("settings");
        menuFile.getItems().addAll(open, settings);
        Menu menuHelp = new Menu("Help");

        MenuItem about = new MenuItem("About");about.setOnAction(event -> getHostServices().showDocument("https://ru.wikipedia.org/wiki/IntelliJ_IDEA"));
        MenuItem CheckUpdate = new MenuItem("Check Update");
        menuHelp.getItems().addAll(about, CheckUpdate);
        menuBar.getMenus().addAll(menuFile, menuHelp); menuBar.setPrefWidth(200);
        TextField textField=new TextField();textField.setPrefWidth(120);textField.setFont(new Font ("Times New Roman",14));
        Label labelPlus = new Label();labelPlus.setPrefWidth(80); labelPlus.setFont(new Font("Impact", 20));
        Random random=new Random();
        FlowPane flowChet =new FlowPane(textField,labelPlus);flowChet.setPrefWidth(200);
        FlowPane flowMenu =new FlowPane(Orientation.VERTICAL,menuBar,flowChet);flowMenu.setMaxHeight(200);flowMenu.setPrefHeight(50.1);
        FlowPane flowPane =new FlowPane(flowMenu);flowPane.setPrefWidth(200);
        for (int i = 0; i < colors.length; i++) {
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            colors[i]=Color.color(r,g,b);
            button[i].setPrefSize(50, 50);button[i].setStyle("-fx-background-color: #dffdff;");
            button[i].setTextFill(colors[i]);
            button[i].setFont(new Font("Impact", 25));
            labelPlus.setTextFill(colors[0]);
            flowPane.getChildren().addAll(button[i]);
            int finalI = i;
            button[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    textField.appendText(button[finalI].getText());
                }});
        }
        button[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                first[0] = Integer.parseInt(textField.getText());
                textField.setText("");
                labelPlus.setText("+");
                button[12].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        second[0] = Integer.parseInt(textField.getText());
                        int sum = first[0]+second[0];
                        labelPlus.setText(button[12].getText()+Integer.toString(sum));
                    }
                });
            }});
        button[7].setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                first[0] = Integer.parseInt(textField.getText());
                textField.setText("");
                labelPlus.setText("-");
                button[12].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        second[0] = Integer.parseInt(textField.getText());
                        int sum = first[0]-second[0];
                        labelPlus.setText(button[12].getText()+Integer.toString(sum));
                    }
                });
            }});
        button[11].setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                first[0] = Integer.parseInt(textField.getText());
                textField.setText("");
                labelPlus.setText("*");
                button[12].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        second[0] = Integer.parseInt(textField.getText());
                        int sum = first[0]*second[0];
                        labelPlus.setText(button[12].getText()+Integer.toString(sum));
                    }
                });
            }});
        button[15].setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                first[0] = Integer.parseInt(textField.getText());
                textField.setText("");
                labelPlus.setText("/");
                button[12].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        second[0] = Integer.parseInt(textField.getText());
                        int sum = first[0]/second[0];
                        labelPlus.setText(button[12].getText()+Integer.toString(sum));
                    }
                });
            }});

        primaryStage.setScene(new Scene(new Group(flowPane))); primaryStage.show();





    }


    public static void main(String[] args) {
        launch(args);
    }
}


