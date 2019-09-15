# Course Registration Platform

## Instruction
* example like flow
* user can:
  1. Login system
  1. Select course
  1. Review selection
  1. Cancel selection

## Class
```
Class: Course
Data: courseId, courseName, startTime, endTime, teacher, credit
```
```
Class: Student
Data: neuId, name, phone, semester,courses
Behaviour:
loginSystem() {
    CourseSystem.login(neuId);
}
registerCourse(course) {
    if (courses.classAvailable())
        CourseSystem.register(neuId, course);
    else
        Error;
}
review() {
    System.out.print(this.courses);
}
cancel(neuId, course) {
    CourseSystem.cancelCourse(course);
}
```
```
Class CourseSystem
Data: studentList, courses
Behaviour:
login(neuId) {
    List<Student> studentList;
    foreach(Student student in studentList) {
        if (student.neuId == neuId)
            return true;
    }
    return false;
}
register(neuId, course) {
    Student student = findStudentById(neuId);
    List<Course> studentCourses = student.course;
    boolean hasConflict = false;
    //conflict with rules, like credit requirement
    //conflict with registered courses
    const MAX_CREDIT = 8;
    int currentCredit = course.credit;
    foreach(Course registedCourse in studentCourses) {
        if ((course.startTime > registedCourse.startTime && course.startTime < registedCourse.endTime)
        || (course.endTime > registedCourse.startTime && course.endTime < registedCourse.endTime)
        ) {
            hasConflict = true;
            break;
        }
        currentCredit += registedCourse.credit;
    }
    if (MAX_CREDIT < currentCredit) {
        hasConflict = true;
    }
    if (!hasConflict) {
        studentCourses.add(course);
        return true;
    }
    return false;
}
cancel(neuId, course) {
    Student student = findStudentById(neuId);
    List<Course> studentCourses = student.course;
    studentCourses.remove(course);
}
```
