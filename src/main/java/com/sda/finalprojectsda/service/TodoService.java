package com.sda.finalprojectsda.service;

import com.sda.finalprojectsda.model.Todo;
import com.sda.finalprojectsda.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// class responsible for business logic
@Service
public class TodoService {

    private final TodoRepository todoRepo;

    TodoService(TodoRepository repo) {
        this.todoRepo = repo;
    }

    public List<Todo> getAllTasks() {
        return todoRepo.findAll();
    }

    public Todo getTaskById(Long id) {
        return todoRepo.getById(id);
    }

    public Todo createTask(Todo task) {
        return todoRepo.save(task);
    }

    public void deleteTaskById(Long id) {
        todoRepo.deleteById(id);
    }

    public Todo updateTask(Todo task) {
        return todoRepo.save(task);
    }

}
