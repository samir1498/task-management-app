package com.samir.taskmanagement.domain.repos;

import java.util.Optional;

import com.samir.taskmanagement.domain.entities.Task;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> findById(int id);

    Task[] findAll();

    void remove(int id);
}
