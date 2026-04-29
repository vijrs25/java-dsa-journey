package javaAdvance.oops.inheritance;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void work() {
        System.out.println(name + " is working");
    }

    void showDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(int id, String name, double salary, String programmingLanguage) {
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void work() {
        super.work();
        System.out.println(name + " is writing code in " + programmingLanguage);
    }

    void debugCode() {
        System.out.println(name + " is debugging code");
    }

    void showDeveloperDetails() {
        super.showDetails();
        System.out.println("Language: " + programmingLanguage);
    }
}

public class ExampleClass {
    public static void main(String[] args) {
        Developer dev = new Developer(101, "Vijay", 80000, "Java");

        dev.showDeveloperDetails();
        dev.work();
        dev.debugCode();
    }
}

