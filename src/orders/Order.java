package orders;

import peoples.Manager;
import peoples.Repair;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int maxTodoIndex = TodosList.getAmountOfTodos();

        String pattern = "\\b(\\d+)\\b";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(stringByTodosList);

        while(m.find()) {
            int index = Integer.parseInt(m.group());
            if (index >= 0 && index < maxTodoIndex) {
                setOfTodos.add(index);
            }
        }

    }

    public void addTodo(int todoId) {
        setOfTodos.add(todoId);
    }

    public void deleteTodo(int todoId) {
        setOfTodos.remove(todoId);
    }

    public void printSetOfTodos() {
        for (int id : setOfTodos) {
            System.out.println(TodosList.getFullInfoByTodoId(id));
        }
    }
}
