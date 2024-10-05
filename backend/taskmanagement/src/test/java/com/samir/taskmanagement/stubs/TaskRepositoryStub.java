package com.samir.taskmanagement.stubs;

import static org.assertj.core.api.Assertions.in;

import java.util.Map;
import java.util.Optional;

import com.samir.taskmanagement.domain.entities.Task;
import com.samir.taskmanagement.domain.repos.TaskRepository;

public class TaskRepositoryStub implements TaskRepository {

    private final Map<Integer, Task> tasks;
    int count = 0;

    public TaskRepositoryStub(Map<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public Task save(Task task) {
        if (this.tasks.containsKey(task.getId())) {
            this.tasks.replace(task.getId(), task);
            return this.tasks.get(task.getId());
        }
        var id = ++count;
        task.setId(id);
        this.tasks.put(id, task);
        return task;
    }

    @Override
    public Optional<Task> findById(int id) {
        return Optional.ofNullable(this.tasks.get(id));
    }

    @Override
    public Task[] findAll() {
        return this.tasks.values().toArray(Task[]::new);
    }

    @Override
    public void remove(int id) {
        this.tasks.remove(id);
    }

}
