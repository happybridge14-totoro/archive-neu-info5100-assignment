package assignment;

import java.util.*;

class Course {
    // Members
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    // Getters and setters
    public int getCourseId() {
        return this.courseId;
    }
    public void setCourseId(int courseId) {
        if (courseId < 1) {
            throw new IllegalArgumentException("Course ID is less than 0");
        }
        this.courseId = courseId;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public void setCourseName(String courseName) {
        int length = courseName.length();
        if (length < 10) {
            throw new IllegalArgumentException("The minimum length of course name is 10");
        }
        if (length > 60) {
            throw new IllegalArgumentException("The maximum length of course name is 60");
        }
        this.courseName = courseName;
    }
    public int getMaxCapacity() {
        return this.maxCapacity;
    }
    public void setMaxCapcity(int maxCapacity) {
        if (maxCapacity < 10) {
            throw new IllegalArgumentException("The max capacity shouldn't be less than 10");
        }
        if (maxCapacity > 100) {
            throw new IllegalArgumentException("The max capacity shouldn't be greater than 100");
        }
        this.maxCapacity = maxCapacity;
    }
    public int getProfessorId() {
        return this.professorId;
    }
    public void setProfessorId(int professorId) {
        if (professorId < 100000 || professorId > 999999) {
            throw new IllegalArgumentException("The professor ID should be six digit integer");
        }
        this.professorId = professorId;
    }
    public int getCredits() {
        return this.credits;
    }
    public void setCredits(int credits) {
        if (credits < 1 || credits > 9) {
            throw new IllegalArgumentException("The credits be a single digit but greater than 0");
        }
        this.credits = credits;
    }
    // Maybe it is better to return the clone of the studentIds?
    public int[] getStudentsIds() {
        return this.studentIds;
    }
    // Since there is the method for registing student, maybe it is not proper to have set method.
    public void setStudentsIds(int[] studentsIds) {
        this.studentIds = studentsIds;
    }

    //Constructors
    Course(int courseId) {
        this.setCourseId(courseId);
        this.courseName = null;
        this.maxCapacity = 0;
        this.professorId = 0;
        this.credits = 0;
        this.studentIds = null;
    }
    Course(int courseId, int professorId) {
        this.setCourseId(courseId);
        this.setProfessorId(professorId);
        this.courseName = null;
        this.maxCapacity = 0;
        this.credits = 0;
        this.studentIds = null;
    }
    Course(int courseId, int professorId, int credits) {
        this.setCourseId(courseId);
        this.setProfessorId(professorId);
        this.setCredits(credits);
        this.courseName = null;
        this.maxCapacity = 0;
        this.studentIds = null;
    }

    //Overriders
    public String toString() {
        return "courseId: " + this.courseId +
            ";\r\ncourseName: " + this.courseName +
            ";\r\nmaxCapacity: " + this.maxCapacity +
            ";\r\nprofessorId: " + this.professorId +
            ";\r\ncredits: " + this.credits +
            ";\r\nstudentIds: " + Arrays.toString(this.studentIds);
    }

    //Methods
    public void registerStudent(int studentId) {
        // Need some rules for the student id?
        // For example, greater than 0, etc.
        // if (studentId < 0) {
        //     throw new IllegalArgumentException("The student id should be greater than 0");
        // }
        if (this.studentIds == null) {
            this.studentIds = new int[1];
            this.studentIds[0] = studentId;
        } else {
            int length = this.studentIds.length;
            int[] targetAry = new int[length + 1];
            System.arraycopy(this.studentIds, 0, targetAry, 0, length);
            this.studentIds = targetAry;
            this.studentIds[length] = studentId;
        }
    }

    public int[] removeDuplicates(int[] studentIds) {
        if (this.studentIds != null) {
            // Classic method
            // int length = studentIds.length;
            // ArrayList<Integer> tmp = new ArrayList<Integer>();
            // for (int i : studentIds) {
            //     if (!tmp.contains(i)) {
            //         tmp.add(i);
            //     }
            // }
            // int[] retAry = new int[tmp.size()];
            // for(int i = 0; i < tmp.size(); i++) {
            //     retAry[i] = tmp.get(i).intValue();
            // }
            // return retAry;

            // Using stream is may be the best way.
            return Arrays.stream(studentIds).distinct().toArray();
        } else {
            return null;
        }
    }

    static public void main(String args[]) {
        Course courseTest = new Course(1);
        System.out.println(courseTest);
        courseTest.registerStudent(1);
        courseTest.registerStudent(2);
        courseTest.registerStudent(3);
        courseTest.registerStudent(1);
        courseTest.registerStudent(2);
        System.out.println(courseTest);
        System.out.println(Arrays.toString(courseTest.removeDuplicates(courseTest.getStudentsIds())));
    }
}
