package validate;

import orders.TodosList;

import java.util.Scanner;

public class validateInput {

    public static int getCorrectTodoNumber() {

        Scanner scanner = new Scanner(System.in);

        int todoIndex;
        int maxTodosIndex = TodosList.getTodosListLength();

        while (true) {
            System.out.println("Введите число:");
            if (!scanner.hasNextInt()) {
                System.out.println("Это не число. Попробуйте еще раз.");
                scanner.next();
                continue;
            }

            todoIndex = scanner.nextInt();
            if (todoIndex < 0 || todoIndex > maxTodosIndex) {
                System.out.println("Неправильно набраное число. Попробуйте еще раз.");
            } else {
                break;
            }
        }
        return todoIndex;

        //        while (true) {
//            try {
//                System.out.println("Enter the number:");
//                a = scanner.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("It's not a number. Try again");
//                scanner.next();
//                continue;
//            }
//            if (a < 0 || a >= 6) {
//                System.out.println("Incorrect number. Try again");
//            } else {
//                break;
//            }
//        }
    }


}
