package ru.alfabank.developer;

import ru.alfabank.enums.TaskStatus;
import ru.alfabank.enums.TaskType;
import ru.alfabank.tasks.Epic;
import ru.alfabank.tasks.SubTask;
import ru.alfabank.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private List<Task> tasks = new ArrayList<>();

    // ========= 2.3 Создание эпика ====================================================================================
    public void addNewEpic(int taskId, String taskName, String taskDescription, TaskStatus taskStatus, TaskType taskType) {
        Epic task = new Epic(taskId, taskName, taskDescription, taskStatus, taskType);
        System.out.println(task);  // временный вывод для проверки создания сущности
        tasks.add(task);
    }

    // ========= 2.3 Создание саба =====================================================================================
    public void addNewSub(int taskId, String taskName, String taskDescription, TaskStatus taskStatus, TaskType taskType,
                          int parentId) {
        boolean parentExists = false;

        for (Task checkTask : tasks) {
            if (checkTask.getTaskId() == parentId && checkTask.getTaskType() == TaskType.Epic) {
                parentExists = true;
                break;
            }
        }

        if (parentExists) {
            SubTask task = new SubTask(taskId, taskName, taskDescription, taskStatus, taskType, parentId);
            System.out.println(task);  // временный вывод для проверки создания сущности
            tasks.add(task);
        } else {
            System.out.println("Ошибка: Родительская задача с id " + parentId
                    + " не существует. Невозможно добавить подзадачу SubTask.");
        }
    }

    // ========= 2.1 Получение списка всех задач =======================================================================
    public void getAllTasks() {
        tasks.forEach(System.out::println);
    }

    // ========= 2.2 Удаление всех задач ===============================================================================
    public void deleteAllTasks() {
        tasks.clear();
    }

    // ========= 2.4 Получение задачи по номеру (id) ===================================================================
    public void getTaskById(int targetTaskId) {
        boolean targetTaskIdExists = false;

        for (Task checkTask : tasks) {
            if (checkTask.getTaskId() == targetTaskId) {
                System.out.println(checkTask);
                targetTaskIdExists = true;
                break;
            }
        }

        if (!targetTaskIdExists) {
            System.out.println("Ошибка: Задача с id " + targetTaskId + " не существует.");
        }
    }
}