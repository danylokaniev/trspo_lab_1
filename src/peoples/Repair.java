package peoples;

public class Repair {

    private int salary;
    private int age;
    private String name;


    public Repair() {
        this.age = 0;
        this.salary = 0;
        this.name = "Not indicated";
    }

    public Repair(int salary, int age, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("\nRepair name: " + name);
        System.out.println("\t   salary: " + salary);
        System.out.println("\t   age: " + age);
    }
}
