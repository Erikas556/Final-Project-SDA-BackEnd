package com.sda.finalprojectsda.controller;

import com.sda.finalprojectsda.model.Todo;
import com.sda.finalprojectsda.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// class responsible to send HTTP requests to the client
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // method to retrieve all tasks from DB
    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getTasks() {

        List<Todo> todoList = todoService.getAllTasks();
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    // method to retrieve a single task from DB by Id
    @GetMapping("{id}")
    public ResponseEntity<Todo> getTaskById(@PathVariable Long id) {
        Todo task = todoService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // method to create a task in DB
    @PostMapping("/create")
    public ResponseEntity<Todo> createTask(@RequestBody Todo task) {
        Todo newTask = todoService.createTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    // method to delete a task by it's ID from DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Todo> deleteTaskById(@PathVariable Long id) {
        todoService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // method to update a task in DB
    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTask(@RequestBody Todo todo, @PathVariable Long id) {
        Todo updatedTask = todoService.getTaskById(id);
        updatedTask.setTask(todo.getTask());
        todoService.updateTask(updatedTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}
