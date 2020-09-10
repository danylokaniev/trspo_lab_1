package orders;

import peoples.Manager;
import peoples.Repair;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private Repair repair;
    private Manager manager;
    private int id;
    private boolean isFinished;
    TreeSet<Integer> setOfTodos = new TreeSet<>();

    public Order(Repair repair, Manager manager, int id) {
        this.repair = repair;
        this.manager = manager;
        this.id = id;
        this.isFinished = false;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void toggleFinishState() {
        isFinished = !this.isFinished;
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

    public void createSetOfTodos(String stringByTodosList) {
        int maxTodoIndex = TodosList.getAmountOfTodos();

        String pattern = "\\b(\\d+)\\b";

        Pattern regex = Pattern.compile(pattern);

        Matcher mathces = regex.matcher(stringByTodosList);

        while (mathces.find()) {
            int index = Integer.parseInt(mathces.group());
            if (index >= 0 && index < maxTodoIndex) {
                setOfTodos.add(index);
            }
        }

    }
}
