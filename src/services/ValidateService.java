package services;

import java.util.Scanner;

public class ValidateService {

    public static int getCorrectNumber(int max) {

        Scanner scanner = new Scanner(System.in);

        int id;

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("\tЭто не число. Попробуйте еще раз.");
                scanner.next();
                continue;
            }

            id = scanner.nextInt();

            if (id < 0 || id >= max) {
                System.out.println("\tНеправильно набраное число. Доступный диапазон от 0 до " +
                        (max - 1) + ". Попробуйте еще раз.");
            } else {
                break;
            }
        }

        return id;
    }
}
