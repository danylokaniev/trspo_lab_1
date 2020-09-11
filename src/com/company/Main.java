package com.company;

import orders.TodosList;
import peoples.Client;
import peoples.Manager;
import peoples.Repair;

public class Main {
    public static void main(String[] args) {
        // Добавляем Todo элементы в список
        TodosList.addTodos();

        new Client("Пушкина 3", "Вася Пупкин");
        new Client("Майдан Независимости 12", "Всеволод Баженов");
        new Client("Горбачего 15", "Григорий Анкурасян");
        new Client("Птушкина 4", "Владимир Горбачев");

        new Repair(1750, 33, "Александр Шакалов");
        new Repair(2000, 40, "Григорий Лупс");
        new Repair(2150, 43, "Аргентин Скворечник");

        Manager manager = new Manager(2700, "Сергей Скворнов");

        // Запускаем приложение
        App.startApp(manager);
    }
}
