package com.sda.finalprojectsda.repository;

import com.sda.finalprojectsda.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// interface which is responsible for handling queries to DB
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

     void deleteTodoById(Long id);


}
