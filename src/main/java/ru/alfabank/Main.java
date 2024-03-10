package ru.alfabank;

import ru.alfabank.enums.TaskType;
import ru.alfabank.developer.Developer;
import ru.alfabank.enums.TaskStatus;

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();
        System.out.println("\n \n        === ЛОГ ВЫПОЛНЕНИЯ ===");
        System.out.println("\n 1. Создаем Эпик... ");
        developer.addNewEpic(1, "Название Эпика 1", "Описание Эпика 1",
                TaskStatus.TO_DO, TaskType.Epic);
        System.out.println("\n 2. Создаем Саб... ");
        developer.addNewSub(101, "Название Саба 101", "Описание Саба 101",
                TaskStatus.TO_DO, TaskType.Sub, 1);
        System.out.println("\n 3. Создаем Саб с несуществующим Эпиком... ");
        developer.addNewSub(102, "Название Саба 102", "Описание Саба 102",
                TaskStatus.TO_DO, TaskType.Sub, 9);
        System.out.println("\n 4. Выводим список всех задач... ");
        developer.getAllTasks();
        System.out.println("\n 5. Выводим задачу по номеру ID...");
        developer.getTaskById(1);
        System.out.println("\n 6. Пытаемся вывести задачу по несуществующему номеру ID...");
        developer.getTaskById(9);
        System.out.println("\n 7. Удаляем все задачи... ");
        developer.deleteAllTasks();
        System.out.println("\n 8. Выводим список всех задач после удаления...");
        developer.getAllTasks();
    }
}