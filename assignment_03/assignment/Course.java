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

    //Q3. Add a function called removeDuplicates in Course class
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

    //Q4. Implement the following method in Course class.
    private int factorial(int n) {
        return n > 1 ? factorial(n - 1) * n : 1;
    }
    public int groupsOfStudents(int[] studentIds) {
        //Suppose there is no duplicates ids in the string, or should call removeDuplicates at first
        //studentIds = removeDuplicates(studentsIds);
        int odd = 0;
        int even = 0;
        for (int i : studentIds) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd ++;
            }
        }
        // odd number plus odd number is even number, even number plus even number is evennumber
        // So just calculate the possibility of odd numbers and even numbers
        //C(n,2) = n!/(2!*(n-2)!)
        return factorial(odd) / factorial(odd - 2) / 2 + factorial(even) / factorial(even - 2) / 2;
    }

    //Q5. countAndSay
    //leetcode 38
    private String readTheString(String input) {
        int count = 1;
        char current = input.charAt(0);
        // String output = "";
        // Using stringbuilder seems to be the best way to do so.
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (tmp != current) {
                output.append(count).append(current);
                // output += count;
                // output += current;
                count = 1;
                current = tmp;
            } else {
                count++;
            }
        }
        output.append(count).append(current);
        // output += count;
        // output += current;
        return output.toString();
        // return output;
    }
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return readTheString(countAndSay(--n));
    }

    //Q6. Given an input string , reverse the string word by word.
    public String reverseWord(String input) {
        String[] tmpAry = input.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = tmpAry.length - 1; i > 0; i--) {
            output.append(tmpAry[i]).append(" ");
        }
        output.append(tmpAry[0]);
        return output.toString();
    }

    // Q7. Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    //leetcode 54
    //My i
    public int[] spiralOrder(int[][] matrix) {
        int[][] rules = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int direction = 3;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int length = columns * rows;
        int [] result = new int[length];
        int currentX = 0;
        int currentY = 0;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        for (int i = 0; i < columns * rows; i++) {
            result[i] = matrix[currentY][currentX];
                if ((direction == 0 && (currentX + rules[direction][0]) > right) ||
                    (direction == 2 && (currentX + rules[direction][0]) < left) ||
                    (direction == 1 && (currentY + rules[direction][1]) > bottom) ||
                    (direction == 3 && (currentY + rules[direction][1]) < top)
                ) {
                    direction = ++direction % 4;
                }
            currentX += rules[direction][0];
            currentY += rules[direction][1];
            if (currentX == left && currentY == top + 1 && i != columns * rows - 1) {
                if (++left < right) {
                    right--;
                }
                if (++top < bottom) {
                    bottom--;
                }
            }
        }
        return result;
    }

    // Q8. The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
    public String convert(String s, int numRows) {
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        boolean isDownDirection = true;
        int currentRow = 0;
        for (int i = 0; i < s.length(); i++) {
            builders[currentRow].append(s.charAt(i));
            if (currentRow == 0) {
                isDownDirection = true;
            }
            if (currentRow == numRows - 1) {
                isDownDirection = false;
            }
            if (isDownDirection) {
                ++currentRow;
            } else {
                --currentRow;
            }
        }
        for (int i = 1; i < numRows; i++) {
            builders[0].append(builders[i]);
        }
        return builders[0].toString();
    }

    static public void main(String args[]) {
        System.out.println("Write a Java class named 'Course'");
        Course courseTest = new Course(1);
        System.out.println(courseTest);
        System.out.println();

        System.out.println("Q3. Add a function called removeDuplicates in Course class:");
        courseTest.registerStudent(1);
        courseTest.registerStudent(6);
        courseTest.registerStudent(2);
        courseTest.registerStudent(3);
        courseTest.registerStudent(2);
        courseTest.registerStudent(4);
        courseTest.registerStudent(5);
        courseTest.registerStudent(6);
        System.out.println("Input: " + Arrays.toString(courseTest.getStudentsIds()));
        int[] noDuplicatedArray = courseTest.removeDuplicates(courseTest.getStudentsIds());
        System.out.println("Output: " + Arrays.toString(noDuplicatedArray));
        System.out.println();

        System.out.println("Q4. Implement the following method in Course class.");
        System.out.println("Input: " + Arrays.toString(noDuplicatedArray));
        System.out.println("Output: " + courseTest.groupsOfStudents(noDuplicatedArray));
        System.out.println();

        System.out.println("Q5. The count-and-say sequence is a sequence of integers with the first five terms as following:");
        System.out.println("Input: 1");
        System.out.println("Output: " + courseTest.countAndSay(1));
        System.out.println("Input: 5");
        System.out.println("Output: " + courseTest.countAndSay(5));
        System.out.println("Input: 30");
        System.out.println("Output: " + courseTest.countAndSay(30));
        System.out.println();

        System.out.println("Q6. Given an input string , reverse the string word by word.");
        System.out.println("Input: the sky is blue");
        System.out.println("Output: " + courseTest.reverseWord("the sky is blue"));
        System.out.println();

        System.out.println("Q7. Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.");
        System.out.println("Input: ");
        System.out.println("[");
        System.out.println(" [ 1, 2, 3 ],");
        System.out.println(" [ 4, 5, 6 ],");
        System.out.println(" [ 7, 8, 9 ]");
        System.out.println("]");
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Output: " + Arrays.toString(courseTest.spiralOrder(matrix)));
        System.out.println();

        System.out.println("Q8. Given an input string , reverse the string word by word.");
        System.out.println("Input: s = \"PAYPALISHIRING\", numRows = 4");
        System.out.println("Output: " + courseTest.convert("PAYPALISHIRING", 4));
        System.out.println();

        System.out.println("Q9. Explain Encapsulation with an example. (Write at least 30-40 words).");
        System.out.println("This class is an example for encapsulation");
        System.out.println("For example, courseId is not directly exposed to public");
        System.out.println("If other classes want to get the value of courseId, it can be gotten by getCourseId() function");
        System.out.println("If other classes want to set the value of courseId, it should follow the rules of the setter function, in this example, no less than 0");
        System.out.println("I think it might be better if the studentIds doesn't have the getter and setter method");
        System.out.println("registerStudent() function is a very good method instead of setting of studentIds");
        System.out.println("Expose an array to public, despite it is exposed by getter method, might be dangerous");
        System.out.println("Maybe it might be better to return the clone of the array, or make a new array");
        System.out.println();

        System.out.println("Q10. What is the difference between Encapsulation and Abstraction");
        System.out.println("Abstraction hides details at the design level, while Encapsulation hides details at the implementation level.");
        System.out.println();
    }
}
