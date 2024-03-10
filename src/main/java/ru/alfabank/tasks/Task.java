package ru.alfabank.tasks;

import lombok.Getter;
import lombok.Setter;
import ru.alfabank.enums.TaskStatus;
import ru.alfabank.enums.TaskType;

@Getter
@Setter
public class Task {
    private final int taskId;
    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;
    private TaskType taskType;

    public Task(int taskId, String taskName, String taskDescription, TaskStatus taskStatus) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }
}