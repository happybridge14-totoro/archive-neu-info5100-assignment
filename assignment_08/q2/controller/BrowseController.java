package q2.controller;

import q2.view.StudentListPage;
import q2.model.StageData;
import q2.model.StudentData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import q2.dataproto.ScreenType;


public class BrowseController {
  private StudentListPage page;
  private StageData data;
  private StudentData studentData;

  public BrowseController(StageData data, StudentData studentData) {
    this.data = data;
    this.studentData = studentData;
    EventHandler<ActionEvent> backEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            data.setValue(ScreenType.MENU);
        }
    };
    this.page = new StudentListPage(studentData.getArrayData(), backEvent);
  }
  public StudentListPage getView() {
    return this.page;
  }
}
