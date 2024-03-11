package ru.alfabank;

import ru.alfabank.developer.Developer;
import ru.alfabank.enums.TaskStatus;

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();
        System.out.println("\n \n        === ЛОГ ВЫПОЛНЕНИЯ ===");
        System.out.println("\n 1. Создаем Эпик 1 (и затем три подзадачи)... ");
        developer.addNewEpic(1, "Название Эпика 1", "Описание Эпика 1",
                TaskStatus.TO_DO);
        System.out.println("\n 2. Создаем Саб 1... ");
        developer.addNewSub(101, "Название Саба 101", "Описание Саба 101",
                TaskStatus.DONE, 1);
        System.out.println("\n 3. Создаем Саб 2... ");
        developer.addNewSub(102, "Название Саба 102", "Описание Саба 102",
                TaskStatus.DONE, 1);
        System.out.println("\n 4. Создаем Саб 3... ");
        developer.addNewSub(103, "Название Саба 103", "Описание Саба 103",
                TaskStatus.DONE, 1);
        System.out.println("\n 5. Создаем Эпик 2 (без подзадач)... ");
        developer.addNewEpic(2, "Название Эпика 2", "Описание Эпика 2",
                TaskStatus.TO_DO);
        System.out.println("\n 6. Создаем Саб с несуществующим Эпиком (ID 9)... ");
        developer.addNewSub(104, "Название Саба 104", "Описание Саба 104",
                TaskStatus.TO_DO, 9);
        System.out.println("\n 7. Выводим список всех задач... ");
        developer.getAllTasks();
        System.out.println("\n 8. Выводим задачу по номеру ID (1)...");
        developer.getTaskById(1);
        System.out.println("\n 9. Пытаемся вывести задачу по несуществующему номеру ID (9)...");
        developer.getTaskById(9);
        System.out.println("\n 10. Обновляем поля задачи (ID 101)...");
        developer.updateTaskById(101, "Измененное название Саба 1",
                "Измененное описание Саба 1");
        System.out.println("\n 11. Выводим все Сабы у Эпика (ID 1)...");
        developer.getAllSubsFromEpicById(1);
        System.out.println("\n 12. Выводим все Сабы у Эпика (ID 2)...");
        developer.getAllSubsFromEpicById(2);
        System.out.println("\n 13. Удаляем задачу (ID 102)...");
        developer.deleteTaskById(102);
        System.out.println("\n 14. Пытаемся удалить задачу (ID 9)...");
        developer.deleteTaskById(9);
        System.out.println("\n 15. Удаляем задачу (ID 2)...");
        developer.deleteTaskById(2);
        System.out.println("\n 16. Меняем статус на DONE у Эпика 1 (все сабы имеют DONE)...");
        developer.updateTaskStatusById(1, TaskStatus.DONE);
        System.out.println("\n 17. Меняем статус на IN_PROGRESS у Эпика 1 (все сабы имеют DONE)");
        developer.updateTaskStatusById(1, TaskStatus.IN_PROGRESS);
        System.out.println("\n 18. Удаляем все задачи... ");
        developer.deleteAllTasks();
        System.out.println("\n 19. Выводим список всех задач после удаления...");
        developer.getAllTasks();
    }
}