package ru.alfabank.tasks;

import ru.alfabank.enums.TaskStatus;

public class SubTask extends Epic {
    private int parentId;

    public SubTask(int taskId, String title, String description, TaskStatus status, int parentId) {
        super(taskId, title, description, status);
        this.parentId = parentId;
    }
}