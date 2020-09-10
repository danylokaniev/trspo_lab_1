package orders;

import java.util.LinkedHashSet;

public class TodosList {

    private static final LinkedHashSet<TodoItem> todoList = new LinkedHashSet<>();

    public static void addTodos() {
        todoList.add(new TodoItem(0, 900, "Покрасить стену"));
        todoList.add(new TodoItem(1, 300, "Починить розетку"));
        todoList.add(new TodoItem(2, 1250, "Положить плитку"));
        todoList.add(new TodoItem(3, 1300, "Заштукатурить стену"));
        todoList.add(new TodoItem(4, 750, "Поклеить обои"));
        todoList.add(new TodoItem(5, 1000, "Собрать мебель"));
    }

    public static void printFullTodoList() {
        for (TodoItem todo : todoList) {
            System.out.println("ID: " + todo.getId() + " Название: `" + todo.getName() + "` Цена: " + todo.getPrice());
        }
    }

    public static int getAmountOfTodos() {
        return todoList.size();
    }

    public static void addTodo(TodoItem todo) {
        todoList.add(todo);
    }

    public static int getPriceByTodoId(int id){
        for (TodoItem todo : todoList) {
            if(todo.getId() == id){
                return todo.getPrice();
            }
        }
        return -1;
    }

     public static String getNameByTodoId(int id){
        for (TodoItem todo : todoList) {
            if(todo.getId() == id){
                return todo.getName();
            }
        }
        return "";
    }

    public static String getFullInfoByTodoId(int id){
        for (TodoItem todo : todoList) {
            if(todo.getId() == id){
                return ("ID: " + todo.getId() + " Название: `" + todo.getName() + "` Цена: " + todo.getPrice());
            }
        }
        return "";
    }







}
