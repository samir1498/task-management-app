package com.samir.taskmanagement.infrastructure.usecases;

import java.util.NoSuchElementException;

import com.samir.taskmanagement.application.usecases.TaskUsecase;
import com.samir.taskmanagement.domain.entities.Task;
import com.samir.taskmanagement.domain.repos.TaskRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskUsecaseImpl implements TaskUsecase {
    private final TaskRepository taskRepo;

    @Override
    public Task createTask(String title, String description) {
        var task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        return taskRepo.save(task);
    }

    @Override
    public Task getTask(int id) {
        return taskRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found with id " + id));

    }

    @Override
    public Task[] listTasks() {
        return this.taskRepo.findAll();
    }

    @Override
    public void removeTask(int id) {
        this.taskRepo.remove(id);
    }

}
