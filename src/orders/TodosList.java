package orders;

import java.io.Serializable;

public enum TodosList {
    PAINT("Покрасить стену"),
    FIXSOCKET("Починить розетку"),
    LAYTILES("Положить плитку"),
    PLASTER("Заштукатурить стену"),
    GLUEWALL("Поклеить обои"),
    COLLECT("Собрать мебель");

    private final String name;

    TodosList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void printFullTodosList() {
        for (TodosList todo : TodosList.values()) {
            System.out.println(todo.ordinal() + ". " + todo.getName());
        }
    }

    public static String getTodoByIndex(int index) {
        return switch (index) {
            case 0 -> TodosList.PAINT.getName();
            case 1 -> TodosList.FIXSOCKET.getName();
            case 2 -> TodosList.LAYTILES.getName();
            case 3 -> TodosList.PLASTER.getName();
            case 4 -> TodosList.GLUEWALL.getName();
            case 5 -> TodosList.COLLECT.getName();
            default -> "";
        };
    }

    public static int getTodosListLength() {
        return TodosList.values().length;
    }

}
