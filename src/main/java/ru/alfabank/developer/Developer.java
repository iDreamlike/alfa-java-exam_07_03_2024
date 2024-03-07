package ru.alfabank.developer;

//import ru.alfabank.tasks.Epic;
//import ru.alfabank.tasks.SubTask;
import ru.alfabank.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private List<Task> tasks;

    public Developer() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public void createTask(Task task) {
        tasks.add(task);
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }
}