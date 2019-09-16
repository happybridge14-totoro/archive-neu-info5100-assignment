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
    }

    public void customSort() {
        // @TODO
        // sort employees array on the basis of firstName and print
        for(Employee employee : employees) {
            System.out.println(employee.firstName);
        }

        // @TODO
        // sort employees array on the basis of age and print

        for(Employee employee : employees) {
            System.out.println(employee.firstName);
        }
    }

    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        // you can verify/test your code here
        assignment2.initializeEmployees();
        System.out.println(assignment2.sumOfSalariesGreaterThanFiveThousands());
    }

}
