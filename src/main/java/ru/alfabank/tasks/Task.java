package ru.alfabank.tasks;

import lombok.Getter;
import ru.alfabank.enums.TaskStatus;

@Getter
public class Task {
    private final int taskId;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(int taskId, String title, String description, TaskStatus status) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
    }
}