package com.samir.taskmanagement.application.usecases;

import com.samir.taskmanagement.domain.entities.Task;

public interface TaskUsecase {
    Task createTask(String title, String description);

    Task getTask(int id);

    Task[] listTasks();

    void removeTask(int id);

    void updateTask(Task task);
}
