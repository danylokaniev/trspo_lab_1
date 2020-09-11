package orders;

public final class TodoItem {

    private final int price;
    private final String name;
    private int id;

    public TodoItem(int id, int price, String name) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override

    public String toString() {
        return ("\t\tID: " + id + " Название: `" + name + "` Цена: " + price);
    }
}
