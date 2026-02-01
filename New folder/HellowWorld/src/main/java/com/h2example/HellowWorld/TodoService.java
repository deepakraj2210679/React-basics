package com.h2example.HellowWorld;

import com.h2example.HellowWorld.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Bean
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepo;

    //create
    public Todo createTodo(Todo todo) {
        todoRepo.save(todo);
        return todo;
    }

    //get by id
    public Todo getTodoById(Long id) {
        return todoRepo.findById(id).orElseThrow(()->new RuntimeException("Todo Not Found"));
    }

    //get all todo
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    //update all todo
    public Todo updateTodo(Todo todo)
    {
        return todoRepo.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepo.deleteById(id);
    }


    public void deleteTodo(Todo todo){
        todoRepo.delete(todo);
    }

    public void deleteAllTodos() {
        todoRepo.deleteAll();
    }

}
