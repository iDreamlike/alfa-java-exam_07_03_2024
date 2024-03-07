package ru.alfabank;

import ru.alfabank.tasks.Epic;
import ru.alfabank.tasks.SubTask;
import ru.alfabank.tasks.Task;
import ru.alfabank.developer.Developer;
import ru.alfabank.enums.TaskStatus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();

        Epic epic1 = new Epic(1,
                "Первый Эпик",
                "Описание первого Эпика",
                TaskStatus.TO_DO);

        SubTask subTask1 = new SubTask(2,
                "Первая Подзадача",
                "Описание первой подзадачи",
                TaskStatus.IN_PROGRESS,
                1);

        epic1.addSubTask(subTask1);

        // ============ 2.3 Создание задачи ======================
        developer.createTask(epic1);
        developer.createTask(subTask1);

        // ============ 2.1 Получение списка всех задач ==========
        System.out.println("=========================");
        System.out.println("Все задачи:");
        List<Task> allTasks = developer.getAllTasks();
        for (Task task : allTasks) {
            System.out.println(task.getTitle());
        }
        System.out.println("=========================");


        // ============ 2.2 Удаление всех задач ==================
        developer.deleteAllTasks();
        System.out.println("=========================");
        System.out.println("Все задачи после удаления:");
        allTasks = developer.getAllTasks();
        for (Task task : allTasks) {
            System.out.println(task.getTitle());
        }
        System.out.println("=========================");

        // ============ 2.4 Получение задачи по номеру (id) =======
        System.out.println("Получить задачу по id=1: ");

        developer.getTaskById(1);

    }
}