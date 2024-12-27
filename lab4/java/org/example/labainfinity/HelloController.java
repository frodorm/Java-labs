package org.example.labainfinity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField genreField;

    @FXML
    private Button addButton;

    @FXML
    private Button showTableButton;



    @FXML
    private void initialize() {

        nameField.setStyle("-fx-background-color: #f4f4f4; -fx-border-radius: 5; -fx-padding: 5;");
        ageField.setStyle("-fx-background-color: #f4f4f4; -fx-border-radius: 5; -fx-padding: 5;");
        authorField.setStyle("-fx-background-color: #f4f4f4; -fx-border-radius: 5; -fx-padding: 5;");
        genreField.setStyle("-fx-background-color: #f4f4f4; -fx-border-radius: 5; -fx-padding: 5;");

        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-border-radius: 5;");
        showTableButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-border-radius: 5;");
        clearButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 14px; -fx-border-radius: 5;");

    }

    @FXML
    private void addBook(ActionEvent event) {
        String name = nameField.getText();
        String ageText = ageField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();

        if (name.isEmpty() || ageText.isEmpty() || author.isEmpty() || genre.isEmpty()) {
            showAlert("Error", "All fields must be filled!");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            DB adapter = new DB();
            adapter.create_or_connection();
            adapter.insert_data(name, age, author, genre);
            showAlert("Success", "Book added successfully!");
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Age must be a valid number!");
        } catch (SQLException e) {
            showAlert("Error", "Database error: " + e.getMessage());
        }
    }

    @FXML
    private void showTable(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TableView.fxml"));
            Parent tableRoot = loader.load();
            Scene tableScene = new Scene(tableRoot);

            Stage tableStage = new Stage();
            tableStage.setScene(tableScene);
            tableStage.setTitle("Book List");
            tableStage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to open table view: " + e.getMessage());
        }
    }

    private void clearFields() {
        nameField.clear();
        ageField.clear();
        authorField.clear();
        genreField.clear();
    }

    @FXML
    private Button clearButton; // Кнопка для очистки данных

    @FXML
    private void clearData(ActionEvent event) {
        DB adapter = new DB();
        adapter.create_or_connection();  // Убедитесь, что соединение с БД установлено

        try {
            adapter.clearAllData();  // Очищаем все данные в таблице Books
            showAlert("Success", "All data has been cleared from the database.");
        } catch (Exception e) {
            showAlert("Error", "An error occurred while clearing the data: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.getDialogPane().setMinWidth(300);
        alert.showAndWait();
    }


}
