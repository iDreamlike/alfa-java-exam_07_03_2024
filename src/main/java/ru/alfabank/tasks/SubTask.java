package ru.alfabank.tasks;

import lombok.Getter;
import ru.alfabank.enums.TaskStatus;
import ru.alfabank.enums.TaskType;

@Getter
public class SubTask extends Task {
    private final int parentId;
    private final TaskType taskType = TaskType.Sub;

    public SubTask(int taskId, String title, String description, TaskStatus status, int parentId) {
        super(taskId, title, description, status);
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "    ======================= "  + "\n"
                + "    ID: " + getTaskId() + "\n"
                + "    taskName: " + getTaskName() + "\n"
                + "    taskDescription: " + getTaskDescription() + "\n"
                + "    taskStatus: " + getTaskStatus() + "\n"
                + "    taskType: " + getTaskType() + "\n"
                + "    ======================= ";
    }
}