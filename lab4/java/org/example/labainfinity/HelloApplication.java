package org.example.labainfinity;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();


            Scene scene = new Scene(root);


            stage.setScene(scene);
            stage.setTitle("My Application");

            stage.setMinWidth(500);
            stage.setMinHeight(400);


            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Error", "Failed to load the FXML file: " + e.getMessage());
        }

        
    }

    private void showErrorDialog(String title, String message) {

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
