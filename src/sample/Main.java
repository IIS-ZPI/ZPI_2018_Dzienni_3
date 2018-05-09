package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    VBox root;

    private ObservableList<String> states = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        root = loader.load();

        init();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void init(){
        states.add("Colorado");
        states.add("Massecuses");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
