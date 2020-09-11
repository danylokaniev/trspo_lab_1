package orders;

import java.util.LinkedHashSet;

public final class TodosList {

    private static LinkedHashSet<TodoItem> todoList;

    public static void addTodos() {
        todoList = new LinkedHashSet<>();

        todoList.add(new TodoItem(0, 900, "Покрасить стену"));
        todoList.add(new TodoItem(1, 300, "Починить розетку"));
        todoList.add(new TodoItem(2, 1250, "Положить плитку"));
        todoList.add(new TodoItem(3, 1300, "Заштукатурить стену"));
        todoList.add(new TodoItem(4, 750, "Поклеить обои"));
        todoList.add(new TodoItem(5, 1000, "Собрать мебель"));
    }


    public static int getAmountOfTodos() {
        return todoList.size();
    }


    public static int getPriceByTodoId(int id) {
        for (TodoItem todo : todoList) {
            if (todo.getId() == id) {
                return todo.getPrice();
            }
        }
        return -1;
    }


    public static void getInfoByTodoId(int id) {
        for (TodoItem todo : todoList) {
            if (todo.getId() == id) {
                System.out.println(todo.toString());
                break;
            }
        }
    }

    public static void printSetOfTodos() {
        for (TodoItem todo : todoList) {
            System.out.println(todo.toString());
        }
    }
}
