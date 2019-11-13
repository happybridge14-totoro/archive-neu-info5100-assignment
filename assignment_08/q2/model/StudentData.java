package q2.model;

import q2.dataproto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class StudentData {
  private LinkedList<Student> dataList;

  public StudentData() {
    dataList = new LinkedList<Student>();
  }

  public boolean addStudent(String id, String name, String gender) {
    Iterator it = dataList.iterator();
    while(it.hasNext()){
      Student data = (Student)it.next();
      if (data.getId().equals(id)) {
        return false;
      }
    }
    dataList.add(new Student(id, name, gender));
    return true;
  }
  public Student[] getArrayData() {
    Student[] ret = new Student[dataList.size()];
    return dataList.toArray(ret);
  }
}
