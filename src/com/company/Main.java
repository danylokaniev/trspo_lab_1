package com.company;

import orders.TodosList;
import people.Client;
import people.Manager;
import people.Repair;

public class Main {
    public static void main(String[] args) {

        TodosList.addTodos();

        new Client("Пушкина 3", "Вася Пупкин");
        new Client("Майдан Независимости 12", "Всеволод Баженов");
        new Client("Горбачего 15", "Григорий Анкурасян");
        new Client("Птушкина 4", "Владимир Горбачев");

        new Repair(1750, 33, "Александр Шакалов");
        new Repair(2000, 40, "Григорий Лупс");
        new Repair(2150, 43, "Аргентин Скворечник");

        new Manager(2700, "Сергей Скворнов");
        new Manager(3500, "Анастасия Васнецова");

        App.startApp();
    }
}
