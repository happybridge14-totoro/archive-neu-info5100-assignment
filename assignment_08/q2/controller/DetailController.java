package q2.controller;

import q2.view.StudentInfoPage;
import q2.model.StageData;
import q2.model.StudentData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import q2.dataproto.ScreenType;


public class DetailController {
  private StudentInfoPage page;
  private StageData data;
  private StudentData studentData;

  public DetailController(StageData data, StudentData studentData) {
    this.data = data;
    this.studentData = studentData;
    EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            String[] dataAry = page.getData();
            if (dataAry != null) {
              if (studentData.addStudent(dataAry[0], dataAry[1], dataAry[2])) {
                page.displaySuccess();
              } else {
                page.displayDuplicatedError();
              }
            }
        }
    };
    EventHandler<ActionEvent> backEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            data.setValue(ScreenType.MENU);
        }
    };
    this.page = new StudentInfoPage(addEvent, backEvent);
  }
  public StudentInfoPage getView() {
    return this.page;
  }
}
