package com.samir.taskmanagement;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samir.taskmanagement.application.usecases.TaskUsecase;
import com.samir.taskmanagement.domain.entities.Task;
import com.samir.taskmanagement.domain.repos.TaskRepository;
import com.samir.taskmanagement.infrastructure.usecases.TaskUsecaseImpl;
import com.samir.taskmanagement.stubs.TaskRepositoryStub;

class TaskUsecaseTest {

    private TaskRepository taskRepo;
    private TaskUsecase underTest;

    @BeforeEach
    void setUp() {
        taskRepo = new TaskRepositoryStub(new HashMap<>());
        underTest = new TaskUsecaseImpl(taskRepo);
    }

    @Test
    void testTaskUsecase() {
        // Arrange
        var task = new Task();
        task.setTitle("Task 1");
        task.setDescription("Task 1 description");

        // Act
        // Assert
        assertThat(task.getTitle()).isNotBlank();
        assertThat(task.getDescription()).isNotEmpty();
    }

    @Test
    void itShouldCreateATask() {
        // Arrange
        var title = "Task 1";
        var description = "Task 1 Description";

        // Act
        var task = underTest.createTask(title, description);

        // Assert
        assertThat(task.getTitle()).isNotBlank();
        assertThat(task.getDescription()).isNotBlank();

    }

    @Test
    void itShouldGetATask() {
        // Arrange
        var title = "Task 1";
        var description = "Task 1 Description";

        var task = underTest.createTask(title, description);
        var savedTask = taskRepo.save(task);
        // Act
        var retrievedTask = underTest.getTask(task.getId());

        // Assert
        assertThat(retrievedTask).isEqualTo(savedTask);

    }

    @Test
    void itShouldNotGetTaskWhenIdNotValid() {
        // Arrange
        var nonValidId = 100;
        // Act
        // Assert
        assertThatThrownBy(() -> underTest.getTask(nonValidId))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void itShouldListTasks() {
        // Arrange
        underTest.createTask("task 1", "description of task 1");
        underTest.createTask("task 2", "description of task 2");

        // Act
        var tasks = underTest.listTasks();

        // Assert
        assertThat(tasks).hasSize(2);
    }

    @Test
    void itShouldDeleteTask() {
        // Arrange
        var task = underTest.createTask("task to delete", "description of task to delete");

        // Act
        underTest.removeTask(task.getId());

        // Assert
        var taskId = task.getId();
        assertThatThrownBy(() -> underTest.getTask(taskId))
                .isInstanceOf(NoSuchElementException.class);
    }

    // TODO: add a test for updating
}
