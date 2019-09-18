// Only used for testing
import java.util.Arrays;
/**
 * Complete all TODO
 * Submit before 22nd September 12:00pm
 */
public class Assignment2 {
    private static final String ORGANISATION = "Northeastern";
    private static final String[] STRS = new String[] {
            //firstname,lastname,age,salary,email,designation
            "John,Doe,24,5400,johndoe@gmail.com,Engineer",
            "Sara,Jones,26,6300,sarajones@gmail.com,TechnicalRecruiter",
            "Noah,Trevor,32,5300,noahtrevor@gmail.com,Writer",
            "Jill,Meyer,34,6800,jillmeyer@gmail.com,Manager",
            "Chris,Strat,36,7600,chrisstrat@gmail.com,Director",
            "Ching,Chi,25,4000,chingchi@gmail.com,Developer",
            "Yue,Hui,28,4900,yuehui@gmail.com,Tester",
            "Amit,Agarwal,27,5700,yuehui@gmail.com,SeniorDeveloper",
            "Tianyu,Wang,26,4500,tianyuwang@gmail.com,Researcher",
            "Ram,Menon,29,5700,rammenon@gmail.com,DataScientist"
    };

    private final Employee[] employees = new Employee[10];

    class Employee implements Comparable<Employee> {
        private String firstName;
        private String lastName;
        private int age;
        private int salary;
        private String email;
        private String designation;
        private String org;

        // For testing
        // Another constructor used for deep clone.
        Employee(Employee target) {
            this.firstName = target.firstName;
            this.lastName = target.lastName;
            this.age = target.age;
            this.salary = target.salary;
            this.email = target.email;
            this.designation = target.designation;
            this.org = target.org;
        }

        Employee(String firstName, String lastName, int age, int salary, String email, String designation, String org) {
            // @TODO
            // initialize all members here
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
            this.email = email;
            this.designation = designation;
            this.org = org;
        }
        // generate getter setters for all Employee members
        public String getFirstName() {
            return this.firstName;
        }
        public void setFirstName(String val) {
            this.firstName = val;
        }
        public String getLastName() {
            return this.lastName;
        }
        public void setLastName(String val) {
            this.lastName = val;
        }
        public int getAge() {
            return this.age;
        }
        public void setAge(int val) {
            this.age = val;
        }
        public int getSalary() {
            return this.salary;
        }
        public void setSalary(int val) {
            this.salary = val;
        }
        public String getEmail() {
            return this.email;
        }
        public void setEmail(String val) {
            this.email = val;
        }
        public String getDesignation() {
            return this.designation;
        }
        public void setDesignation(String val) {
            this.designation = val;
        }
        public String getOrg() {
            return this.org;
        }
        public void setOrg(String val) {
            this.org = val;
        }

        @Override
        public int compareTo(Employee o) {
            // @TODO
            // compare employee by their salary, if salaries are equal, compare by age
            if (this.salary == o.getSalary()) {
                if (this.age > o.getAge()) {
                    return 1;
                } else if (this.age < o.getAge()) {
                    return -1;
                }
            } else if (this.salary > o.getSalary()) {
                return 1;
            } else {
                return -1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            // @TODO
            // implement equals for Employee
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return this.firstName.equals(employee.getFirstName())
                && this.lastName.equals(employee.getLastName())
                && this.age == employee.getAge()
                && this.salary == employee.getSalary()
                && this.email.equals(employee.getEmail())
                && this.designation.equals(employee.getDesignation())
                && this.org.equals(employee.getOrg());
            // return true;
        }

        @Override
        public int hashCode() {
            // @TODO
            // implement hashcode for employee

            // The implementation below is a common method.
            // Since the target of hash is not to create unique fingerprint, it is just to compress the data structure

            // Since String has the maxium lenght of 2^31-1, the prime is 31
            final int PRIME = 31;
            // Hash begin from 1
            int result = 1;
            result = PRIME * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
            result = PRIME * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
            result = PRIME * result + (int) (this.age ^ (this.age >>> 32));
            result = PRIME * result + (int) (this.salary ^ (this.salary >>> 32));
            result = PRIME * result + ((this.email == null) ? 0 : this.email.hashCode());
            result = PRIME * result + ((this.designation == null) ? 0 : this.designation.hashCode());
            result = PRIME * result + ((this.org == null) ? 0 : this.org.hashCode());
            return result;
            // return 0;
        }
    }

    public void initializeEmployees() {
        // @TODO
        // use STRS to create employee objects and store them in employees array
        int index = 0;
        for (String i : Assignment2.STRS) {
            String parts[] = i.split(",");
            //parts[0]: firstName
            //parts[1]: lastName
            //parts[2]: age
            //parts[3]: salary
            //parts[4]: email
            //parts[5]: designation
            this.employees[index++] = new Employee(parts[0],
                                             parts[1],
                                             Integer.parseInt(parts[2]),
                                             Integer.parseInt(parts[3]),
                                             parts[4],
                                             parts[5],
                                             Assignment2.ORGANISATION
                                         );
        }
    }

    public int sumOfSalariesGreaterThanFiveThousands() {
        // @TODO
        // calculate the sum of salaries of employees having salary greater than 5000
        int ret = 0;
        for (Employee i : this.employees) {
            if (i.getSalary() > 5000) {
                ++ret;
            }
        }
        return ret;
        // return 0;
    }

    public void swapSalaries() {
        // @TODO
        // swap salary of even numbered employee with odd numbered employee
        // swap salary of employees[0] with employees[1], employees[2] with employees[3] and so on..
        for (int i = 0; i < this.employees.length - 1; i += 2) {
            int salary1 = this.employees[i].getSalary();
            int salary2 = this.employees[i + 1].getSalary();
            this.employees[i].setSalary(salary2);
            this.employees[i + 1].setSalary(salary1);
        }
    }

    // quick sort method
    // It's really a graceful method
    private int quickSortPartition(Employee[] array, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i].age < array[end].age) {
                Employee tmp = array[i];
                array[i] = array[counter];
                array[counter] = tmp;
                counter++;
            }
        }
        Employee tmp = array[end];
        array[end] = array[counter];
        array[counter] = tmp;
        return counter;
    }

    private void quickSort(Employee[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = this.quickSortPartition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    // merge sort method
    private void mergeSortPartition(Employee[] array, int begin, int middle, int end) {
        if (begin == end) return;
        int length = end - begin + 1;
        Employee tmpArrayLeft[] = new Employee[(middle - begin  + 1)];
        Employee tmpArrayRight[] = new Employee[(end - middle)];

        for (int i = 0; i < middle - begin  + 1; i++) {
            tmpArrayLeft[i] = array[begin + i];
        }
        for (int i = 0; i < end - middle; i++) {
                tmpArrayRight[i] = array[middle + 1 + i];
        }
        int leftI = 0;
        int rightI = 0;
        for (int i = 0; i < length; i++) {
            if (leftI > tmpArrayLeft.length - 1) {
                array[begin + i] = tmpArrayRight[rightI++];
                continue;
            }
            if (rightI > tmpArrayRight.length - 1) {
                array[begin + i] = tmpArrayLeft[leftI++];
                continue;
            }
            if (tmpArrayLeft[leftI].getFirstName().compareTo(tmpArrayRight[rightI].getFirstName()) > 0) {
                array[begin + i] = tmpArrayRight[rightI++];
            } else {
                array[begin + i] = tmpArrayLeft[leftI++];
            }
        }
    }

    private void mergeSort(Employee[] array, int begin, int end) {
        if (begin >= end) return;
        int mid = (end - begin) / 2;
        mergeSort(array, begin, begin + mid);
        mergeSort(array, begin + mid + 1, end);
        mergeSortPartition(array, begin, begin + mid, end);
    }

    // add option param to choose sort rules
    // Try to use two different sort methods
    // Use merge sort for firstName
    // Use quick sort for age
    public void customSort(String option) {
        // @TODO
        // sort employees array on the basis of firstName and print
        // for(Employee employee : employees) {
            // System.out.println(employee.firstName);
        // }

        // @TODO
        // sort employees array on the basis of age and print
        // for(Employee employee : employees) {
            // System.out.println(employee.firstName);
        // }
        if ("firstName" == option) {
            this.mergeSort(this.employees, 0, this.employees.length - 1);
        } else if ("age" == option) {
            this.quickSort(this.employees, 0, this.employees.length - 1);
        }
    }

    // This get method is created for testing
    // It will create a deep clone of the private employees, so the original array won't be affected
    public Employee[] getEmployeesClone() {
        Employee[] clone = new Employee[10];
        for (int i = 0; i < 10; i++) {
            clone[i] = new Employee(this.employees[i]);
        }
        return clone;
    }

    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        // you can verify/test your code here
        System.out.println("Initialization:");
        ///////////////////not testing codes////////////////////////
        assignment2.initializeEmployees();
        ///////////////////////////////////////////////////////////
        System.out.println("Initialization done!");
        System.out.println("");

        // Test compareTo function
        System.out.println("Test compareTo function");
        System.out.println("Print original data:");
        Employee testAry[] = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + ": " + i.getSalary() + "  ");
        }
        System.out.println("");
        Arrays.sort(testAry);
        System.out.println("Print sort data to identify compareTo function:");
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + ": " + i.getSalary() + "  ");
        }
        System.out.println("");
        System.out.println("");

        // Test equals function
        System.out.println("Test equals function");
        testAry = assignment2.getEmployeesClone();
        Employee test0 = testAry[0];
        Employee test1 = testAry[1];
        System.out.println(test0.getFirstName() + ", " + test1.getFirstName());
        System.out.print(test0.getFirstName() + "==" + test1.getFirstName() + "?  ");
        System.out.println(test0.equals(test1));
        System.out.print(test0.getFirstName() + "==" + test0.getFirstName() + "?  ");
        System.out.println(test0.equals(test0));
        System.out.println("");

        // Test hashCode funcion
        System.out.println("Test hashCode function");
        System.out.println("Print hash code for each employee:");
        testAry = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.println(i.getFirstName() + ": " + i.hashCode());
        }
        System.out.println("");

        // Test sum function
        System.out.println("Test sum function");
        System.out.println("The sum of salaries of employees having salary greater than 5000 is:");
        System.out.println(assignment2.sumOfSalariesGreaterThanFiveThousands());
        System.out.println("");

        // Test swap function
        System.out.println("Test swap function");
        System.out.println("Before swaping:");
        testAry = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + ": " + i.getSalary() + "  ");
        }
        System.out.println("");
        ///////////////////not testing codes////////////////////////
        assignment2.swapSalaries();
        ///////////////////////////////////////////////////////////
        System.out.println("After swaping:");
        testAry = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + ": " + i.getSalary() + "  ");
        }
        System.out.println("");
        System.out.println("");

        // Test sort function
        System.out.println("Test sort function by age");
        System.out.print("Original order: ");
        testAry = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + ": " + i.getAge() + "  ");
        }
        System.out.println();
        ///////////////////not testing codes////////////////////////
        assignment2.customSort("age");
        ///////////////////////////////////////////////////////////
        System.out.println("After swaping:");
        testAry = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + ": " + i.getAge() + "  ");
        }
        System.out.println("");
        System.out.println("");

        // Test sort function
        System.out.println("Test sort function by firstName");
        System.out.print("Original order: ");
        testAry = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + "  ");
        }
        System.out.println();
        ///////////////////not testing codes////////////////////////
        assignment2.customSort("firstName");
        ///////////////////////////////////////////////////////////
        System.out.println("After swaping:");
        testAry = assignment2.getEmployeesClone();
        for(Employee i : testAry) {
            System.out.print(i.getFirstName() + "  ");
        }
    }
}
