package peoples;

public class Client {

    private String address;
    private String name;

    public Client() {
        this.address = "Address is not indicated";
        this.name = "Name is not indicated";
    }

    public Client(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("\nClient name: " + name);
        System.out.println("\t   address: " + address);
    }
}
