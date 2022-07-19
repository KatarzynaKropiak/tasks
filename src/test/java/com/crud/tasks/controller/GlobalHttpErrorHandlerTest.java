package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalHttpErrorHandlerTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void handleTaskNotFoundException() {
        //Given
        GlobalHttpErrorHandler globalHttpErrorHandler = new GlobalHttpErrorHandler();
        //When
        ResponseEntity<Object> testResponseEntity = new ResponseEntity<Object>("Task with given id doesn't exist", HttpStatus.BAD_REQUEST);
        //Then
       assertEquals(globalHttpErrorHandler.handleTaskNotFoundException(new TaskNotFoundException()), testResponseEntity);

    }
}