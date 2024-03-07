package ru.alfabank.tasks;

import ru.alfabank.enums.TaskStatus;
import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<SubTask> subTasks;

    public Epic(int taskId, String title, String description, TaskStatus status) {
        super(taskId, title, description, status);
        this.subTasks = new ArrayList<>();
    }

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }
}