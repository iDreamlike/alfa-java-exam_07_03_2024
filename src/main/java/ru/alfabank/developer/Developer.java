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
    public void addNewEpic(int taskId, String taskName, String taskDescription, TaskStatus taskStatus) {
        Epic task = new Epic(taskId, taskName, taskDescription, taskStatus);
        System.out.println(task);  // временный вывод для проверки создания сущности
        tasks.add(task);
    }

    // ========= 2.3 Создание саба =====================================================================================
    public void addNewSub(int taskId, String taskName, String taskDescription, TaskStatus taskStatus, int parentId) {
        boolean parentExists = false;
        Epic parentEpic = null;

        for (Task checkTask : tasks) {
            if (checkTask.getTaskId() == parentId && checkTask.getTaskType() == TaskType.Epic) {
                parentExists = true;
                parentEpic = (Epic) checkTask;
                break;
            }
        }

        if (parentExists) {
            SubTask task = new SubTask(taskId, taskName, taskDescription, taskStatus, parentId);
            parentEpic.addSubTask(task);
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

    // ========= (Вспомогательный. Для других методов) Поиск задачи по id ==============================================
    public Task returnTaskByIdIfExists(int taskId, List<Task> listForSeeking) {

        for (Task checkTask : listForSeeking) {
            if (checkTask.getTaskId() == taskId) {
                return checkTask;
            }
        }

        System.out.println("Ошибка: Задача с id " + taskId + " не существует.");
        return null;
    }

    // ========= 2.4 Получение задачи по номеру (id) ===================================================================
    public void getTaskById(int targetTaskId) {
        Task taskToWork = returnTaskByIdIfExists(targetTaskId, tasks);
        if (taskToWork != null) {
            System.out.println(taskToWork);
        }
    }

    // ========= 2.5 Обновление полей задачи ===========================================================================
    public void updateTaskById(int taskId, String taskName, String taskDescription) {
        Task taskToWork = returnTaskByIdIfExists(taskId, tasks);
        if (taskToWork != null) {
            taskToWork.setTaskName(taskName);
            taskToWork.setTaskDescription(taskDescription);
            System.out.println("Задача с id " + taskId + " успешно обновлена");
            System.out.println(taskToWork);
        }
    }

    // ========= (Вспомогательный. Для других методов) обновление статусов =============================================
    private boolean checkAllSubTasksStatus(Epic epic, TaskStatus status) {

        for (Task subTask : epic.getSubTasks()) {
            if (subTask.getTaskStatus() != status) {
                return false;
            }
        }
        return true;
    }


    // ========= 2.5 Обновление статуса задачи =========================================================================
    public void updateTaskStatusById(int taskId, TaskStatus taskStatus) {
        Task taskToWork = returnTaskByIdIfExists(taskId, tasks);
        if (taskToWork != null) {
            // 3.1 Для обычных задач разработчик может менять статусы как угодно
            if (taskToWork.getTaskType() == TaskType.Sub) {
                taskToWork.setTaskStatus(taskStatus);
            } else if (taskToWork.getTaskType() == TaskType.Epic) {
                boolean allSubTasksToDo = checkAllSubTasksStatus((Epic) taskToWork, TaskStatus.TO_DO);
                boolean allSubTasksDone = checkAllSubTasksStatus((Epic) taskToWork, TaskStatus.DONE);

                if (allSubTasksToDo) {
                    taskToWork.setTaskStatus(TaskStatus.TO_DO); // Если все подзадачи TO DO, эпик должен быть TO DO
                } else if (allSubTasksDone) {
                    taskToWork.setTaskStatus(TaskStatus.DONE); // Если все подзадачи DONE, эпик должен быть DONE
                } else {
                    taskToWork.setTaskStatus(TaskStatus.IN_PROGRESS); // Во всех остальных случаях эпик в статусе IN PROGRESS
                }
                System.out.println(taskToWork);
            }
        }
    }

    // ========= 2.6 Удаление конкретной задачи ========================================================================
    public void deleteTaskById(int taskId) {
        Task taskToWork = returnTaskByIdIfExists(taskId, tasks);
        if (taskToWork != null) {
            tasks.remove(taskToWork);
            System.out.println("Задача с id " + taskId + " успешно удалена из общего списка задач");

            for (Task tmpTask : tasks) {
                if (tmpTask instanceof Epic) {
                    Epic epic = (Epic) tmpTask;
                    List<Task> subTasks = epic.getSubTasks();
                    if (subTasks.removeIf(subTask -> subTask.getTaskId() == taskId)) {
                        System.out.println("Задача с id " + taskId + " успешно удалена из списка подзадач в Эпике с id "
                                + epic.getTaskId());
                    }
                }
            }
        } else {
            System.out.println("Ошибка. Подзадача с id " + taskId + " не существует.");
        }
    }

    // ========= 2.7 Получение всех задач по конкретному эпику =========================================================
    public void getAllSubsFromEpicById(int epicId) {
        Epic epic = (Epic) returnTaskByIdIfExists(epicId, tasks);

        if (epic != null) {
            System.out.println("Подзадачи для Epic с ID " + epicId + ":");
            List<Task> subTasks = epic.getSubTasks();

            if (subTasks.isEmpty()) {
                System.out.println("Нет подзадач для данного Epic.");
            } else {
                for (Task subTask : subTasks) {
                    System.out.println(subTask);
                }
            }
        }
    }
}