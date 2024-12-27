package org.example.labainfinity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.ResultSet;
import java.sql.SQLException;

public class TableViewController {

    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, String> nameColumn;

    @FXML
    private TableColumn<Book, Integer> ageColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> genreColumn;


    @FXML
    private void initialize() {
        setupTableColumns();
        setupRowFactory();
        loadData();
    }


    private void setupTableColumns() {
        tableView.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5;");
        nameColumn.setStyle("-fx-font-weight: bold;");
        ageColumn.setStyle("-fx-font-weight: bold;");
        authorColumn.setStyle("-fx-font-weight: bold;");
        genreColumn.setStyle("-fx-font-weight: bold;");

       
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        loadData();
    }

    private void setupRowFactory() {
        tableView.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected void updateItem(Book item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setStyle("");
                } else {

                    if ("Fiction".equalsIgnoreCase(item.getGenre())) {
                        setStyle("-fx-background-color: #e6f7ff;");
                    } else if ("Science".equalsIgnoreCase(item.getGenre())) {
                        setStyle("-fx-background-color: #f9ffe6;");
                    } else {
                        setStyle("");
                    }
                }
            }
        });
    }


    private void loadData() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        DB adapter = new DB();

        try {
            adapter.create_or_connection();
            ResultSet rs = adapter.SelectData();

            while (rs.next()) {
                books.add(new Book(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("author"),
                        rs.getString("genre")
                ));
            }
        } catch (SQLException e) {
            showAlert("Database Error", "Failed to load data from the database: " + e.getMessage());
        } finally {
            adapter.closeConnection();
        }

        tableView.setItems(books);
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
