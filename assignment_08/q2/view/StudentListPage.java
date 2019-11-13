package q2.view;

import q2.dataproto.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentListPage  extends GridPane {
  private Student[] data;
  public StudentListPage(Student[] data,  EventHandler<ActionEvent> browseEvent) {
    this.data = data;
    this.getStyleClass().add("list");
    Button browse = new BasicButton("Back To Menu");
    browse.setOnAction(browseEvent);
    this.add(browse, 1, 2, 2, 1);

    TableView<Student> tableView = new TableView<Student>();
    TableColumn<Student, String> column1 = new TableColumn<Student, String>("ID");
    column1.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
    TableColumn<Student, String> column2 = new TableColumn<Student, String>("Name");
    column2.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
    TableColumn<Student, String> column3 = new TableColumn<Student, String>("Gender");
    column3.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
    tableView.getColumns().add(column1);
    tableView.getColumns().add(column2);
    tableView.getColumns().add(column3);
    for (int i = 0; i < data.length; i++) {
        tableView.getItems().add(data[i]);
    }
    tableView.getStyleClass().add("table");
    this.add(tableView, 1, 1, 2, 1);
  }
}
