package com.crud.tasks.repository.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbServiceTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private DbService dbService;

    @Test
    void getAllTask() {
    //Given
    taskRepository.deleteAll();
    Task task = new Task();
        task.setTitle("title1");
        task.setContent("content1");
        taskRepository.save(task);
    //When
    List<Task> tasks = dbService.getAllTasks();
    //Then
    assertEquals(1, tasks.size());
    //CleanUp
    taskRepository.deleteAll();
}

    @Test
    void getTask() throws TaskNotFoundException {
        //Given
        Task task = new Task();
        task.setTitle("title1");
        task.setContent("content1");
        taskRepository.save(task);
        //When
        Task testTask = dbService.getTaskById(task.getId());
        //Then
        assertEquals(task.getId(), testTask.getId());
        assertEquals(task.getTitle(), testTask.getTitle());
        assertEquals(task.getContent(), testTask.getContent());
        //CleanUp
        taskRepository.deleteAll();
    }

    @Test
    void deleteTask() {
        //Given
        taskRepository.deleteAll();
        Task task = new Task();
        task.setTitle("title1");
        task.setContent("content1");
        taskRepository.save(task);
        //When
        dbService.deleteTask(task.getId());
        //Then
        assertFalse(taskRepository.existsById(task.getId()));
    }
}