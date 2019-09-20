package Assignment2;
// Used for tax calculation
import java.lang.Math;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
        // Since operation of type double is not realiable, use int to calculate
        int intSum = 0;
        for (Employee i : employees) {
            int salary = (int)(i.getSalary() * 100);
            if (salary > 500000) {
                intSum += salary;
            }
        }
        double sum = intSum / 100.0;
        return sum;
    }

    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        // @TODO
        String ret = "";
        if (employee.getId() % 3 == 0) {
            ret += "Fizz";
        }
        if (employee.getId() % 5 == 0 ) {
            ret += "Buzz";
        }
        if (ret != "") {
            System.out.println(ret);
        }
    }

    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        // @TODO
        // double salary = employee.getSalary();
        int salary = (int)(employee.getSalary() * 100);
        // double tax = 0.0;
        int tax = 0;
        // double taxable = salary - 5000;
        int taxable = salary - 500000;
        if (taxable > 0) {
            tax += taxable * 35;
            salary = 500000;
        }
        taxable = salary - 250000;
        if (taxable > 0) {
            tax += taxable * 25;
            salary = 250000;
        }
        //taxable = salary - 0;
        if (salary > 0) {
            tax += salary * 10;
        }
        // The tax is following "round" rule
        // I haven't found the paper record of the rule, just following the tax calcuated from my Amazon order
        tax = (int)Math.round(tax / 100.0);
        return (tax / 100.0);
    }

    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO
        double tmp = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(tmp);
    }

    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
        int count = 0;
        for (Employee i : employees) {
            if (i.getAge() > 50) {
                ++count;
            }
        }
        return count;
    }

    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        // @TODO
        for (int i = 0; i < employees.length; i++) {
            String strAry[] = employeesStr[i].split(",");
            employees[i] = new Employee(Integer.parseInt(strAry[0]),
                                    strAry[1],
                                    Integer.parseInt(strAry[2]),
                                    Double.parseDouble(strAry[3]));
        }
        return employees;
    }

    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        // @TODO
    }

    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        // @TODO
    }

    public static void main(String args[]) {
        // Test data
        String[] testStringAry = new String[]{"1,John,24,7500",
                                "2,Hail,28,3899.90",
                                "3,Hail2,35,6899.00",
                                "4,Marry,32,1899.98",
                                "5,Marry2,22,9899.23",
                                "6,Tom,43,1000.00",
                                "7,Annie,30,5899.00",
                                "8,David,58,3899.90",
                                "9,Christopher,25,7899.00",
                                "10,George,22,2899.98",
                                "11,Ronald,52,2899.23",
                                "12,Daniel,33,6899.30",
                                "13,Robert,32,4000.00",
                                "14,Emma,23,7899.30",
                                "15,Olivia,43,3899.30",
                                "16,Ava,33,7899.30"};
        // Create a new main object
        Assignment2 mainObj = new Assignment2();
        // Test createEmployees function
        Employee employeesArray[] = mainObj.createEmployees(testStringAry);
        System.out.println("Test createEmployees:");
        for (Employee i : employeesArray) {
            System.out.println("ID:" + i.getId() + ", First Name: " + i.getFirstName() + ", Age: " + i.getAge() + ", Salary: " + i.getSalary());
        }
        System.out.println();
        // Test salaryGreaterThanFiveThousand function
        System.out.println("Test salaryGreaterThanFiveThousand:(expect 60794.13)");
        System.out.println(mainObj.salaryGreaterThanFiveThousand(employeesArray));
        System.out.println();
        // Test fizzBuzz function
        System.out.println("Test fizzBuzz:");
        System.out.println("Test id 1");
        mainObj.fizzBuzz(employeesArray[0]);
        System.out.println("Test id 3");
        mainObj.fizzBuzz(employeesArray[2]);
        System.out.println("Test id 5");
        mainObj.fizzBuzz(employeesArray[4]);
        System.out.println("Test id 15");
        mainObj.fizzBuzz(employeesArray[14]);
        System.out.println();
        // Test calculateTax function
        System.out.println("Test calculateTax:");
        System.out.println("Test salary 1000");
        System.out.println("The tax is: $" + mainObj.calculateTax(employeesArray[5]));
        System.out.println("Test salary 4000");
        System.out.println("The tax is: $" + mainObj.calculateTax(employeesArray[12]));
        System.out.println("Test salary 7500");
        System.out.println("The tax is: $" + mainObj.calculateTax(employeesArray[0]));
        System.out.println();
        // Test sway function
        System.out.println("Test swap:");
        System.out.println("Before swaping:");
        System.out.println("First employee:id-" + employeesArray[6].getId() + ",firstName-" + employeesArray[6].getFirstName() + ",salary-" + employeesArray[6].getSalary());
        System.out.println("Second employee:id-" + employeesArray[7].getId() + ",firstName-" + employeesArray[7].getFirstName() + ",salary-" + employeesArray[7].getSalary());
        mainObj.swap(employeesArray[6], employeesArray[7]);
        System.out.println("After swaping:");
        System.out.println("First employee:id-" + employeesArray[6].getId() + ",firstName-" + employeesArray[6].getFirstName() + ",salary-" + employeesArray[6].getSalary());
        System.out.println("Second employee:id-" + employeesArray[7].getId() + ",firstName-" + employeesArray[7].getFirstName() + ",salary-" + employeesArray[7].getSalary());
        System.out.println();
        // Test employeesAgeGreaterThan50 function
        System.out.println("Test employeesAgeGreaterThan50:(expect 2)");
        System.out.println(mainObj.employeesAgeGreaterThan50(employeesArray));
        System.out.println();
    }
}
