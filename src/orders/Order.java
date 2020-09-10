package orders;

import peoples.Manager;
import peoples.Repair;

import java.util.TreeSet;

public class Order {
    private Repair repair;
    private Manager manager;
    TreeSet<Integer> setOfTodos = new TreeSet<>();

    public Order(Repair repair, Manager manager) {
        this.repair = repair;
        this.manager = manager;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void createSetOfTodos(String stringByTodosList) {

        String[] array = stringByTodosList.split(" ");

        int maxTodoIndex = TodosList.getTodosListLength();

        for (String s : array) {

            if (!s.equals(" ")) {

                int index = Integer.parseInt(s);

                if (index >= 0 && index < maxTodoIndex) {
                    setOfTodos.add(index);
                }
            }
        }
    }

    public void addTodo(int todoIndex) {
        setOfTodos.add(todoIndex);
    }

    public void deleteTodo(int todoIndex) {
        setOfTodos.remove(todoIndex);
    }

    public void printSetOfTodos() {
        for (int todoIndex : setOfTodos) {
            System.out.println(TodosList.getTodoByIndex(todoIndex));
        }
    }
}
