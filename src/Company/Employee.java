package company;

public abstract class Employee {

    private int id;
    private String name;
    private int salary;

    final int companyCode = 101;

    // Constructor
    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // Normal method
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    // Abstract method
    public abstract void work();

    // toString override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Salary: " + salary;
    }
}