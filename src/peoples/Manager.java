package peoples;

public class Manager {

    private int salary;
    private String name;

    public Manager() {
        this.salary = 0;
        this.name = "Not indicated";
    }

    public Manager(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("\nManager name: " + name);
        System.out.println("\t   salary: " + salary);
    }
}
