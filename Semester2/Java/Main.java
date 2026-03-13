class Person {
    String name, gender, address;
    int age;

    Person(String n, String g, String a, int ag) {
        name = n; gender = g; address = a; age = ag;
    }

    void display() {
        System.out.println("Name            : " + name);
        System.out.println("Gender          : " + gender);
        System.out.println("Address         : " + address);
        System.out.println("Age             : " + age);
    }
}

class Employee extends Person {
    int empId;
    String company, qualification;
    double salary;

    Employee(String n, String g, String a, int ag,
             int id, String c, String q, double s) {
        super(n, g, a, ag);
        empId = id; company = c; qualification = q; salary = s;
    }

    void display() {
        super.display();
        System.out.println("Emp ID          : " + empId);
        System.out.println("Company         : " + company);
        System.out.println("Qualification   : " + qualification);
        System.out.println("Salary          : " + salary);
    }
}

class Teacher extends Employee {
    int teacherId;
    String subject, department;

    Teacher(String n, String g, String a, int ag,
            int id, String c, String q, double s,
            int tid, String sub, String dept) {
        super(n, g, a, ag, id, c, q, s);
        teacherId = tid; subject = sub; department = dept;
    }

    void display() {
        super.display();
        System.out.println("Teacher ID      : " + teacherId);
        System.out.println("Subject         : " + subject);
        System.out.println("Department      : " + department);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        Teacher[] t = {
            new Teacher("Abhi","Male","Pune",30,101,"ABC","MSc",45000,1,"Maths","Science"),
            new Teacher("Riya","Female","Mumbai",28,102,"ABC","BEd",42000,2,"Physics","Science")
        };

        for (Teacher x : t)
            x.display();
    }
}
