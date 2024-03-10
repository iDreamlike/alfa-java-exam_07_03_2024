package ru.alfabank.tasks;

import lombok.Getter;
import ru.alfabank.enums.TaskStatus;
import ru.alfabank.enums.TaskType;

@Getter
public class Epic extends Task {

    public Epic(int taskId, String taskName, String taskDescription, TaskStatus taskStatus, TaskType taskType) {
        super(taskId, taskName, taskDescription, taskStatus, taskType);
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