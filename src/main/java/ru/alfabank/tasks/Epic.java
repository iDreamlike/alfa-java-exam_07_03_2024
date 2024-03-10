package ru.alfabank.tasks;

import lombok.Getter;
import ru.alfabank.enums.TaskStatus;
import ru.alfabank.enums.TaskType;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Epic extends Task {
    private final TaskType taskType = TaskType.Epic;
    private List<Task> subTasks = new ArrayList<>();

    public Epic(int taskId, String taskName, String taskDescription, TaskStatus taskStatus) {
        super(taskId, taskName, taskDescription, taskStatus);
    }

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
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