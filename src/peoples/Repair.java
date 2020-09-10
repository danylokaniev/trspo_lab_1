package peoples;

public class Repair {

    private int salary;
    private int age;
    private String name;
    private boolean isFree;


    public Repair() {
        this.age = 0;
        this.salary = 0;
        this.name = "Not indicated";
        this.isFree = true;
    }

    public Repair(int salary, int age, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.isFree = true;
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

    public boolean getFreeState() {
        return isFree;
    }

    public void toggleFreeState() {
        isFree = !this.isFree;
    }

    public void printInfo() {
        System.out.println("\nRepair name: " + name);
        System.out.println("\t salary: " + salary);
        System.out.println("\t    age: " + age);
        System.out.println("\tIs free: " + (isFree ? "yes" : "no"));
    }


}
