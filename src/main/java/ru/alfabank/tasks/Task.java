package ru.alfabank.tasks;

import lombok.Getter;
import ru.alfabank.enums.TaskStatus;
import ru.alfabank.enums.TaskType;

@Getter
public class Task {
    private final int taskId;
    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;
    private TaskType taskType;

    public Task(int taskId, String taskName, String taskDescription, TaskStatus taskStatus, TaskType taskType) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskType = taskType;
    }
}