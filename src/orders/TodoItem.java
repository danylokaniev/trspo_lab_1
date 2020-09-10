package orders;

public class TodoItem {
    private int price;
    private String name;
    private int id;

    public TodoItem(int id, int price, String name) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printInfo() {
        System.out.println(("\t\tID: " + id + " Название: `" + name + "` Цена: " + price));
    }
}
