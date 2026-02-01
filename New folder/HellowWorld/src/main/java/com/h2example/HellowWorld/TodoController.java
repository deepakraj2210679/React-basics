package com.h2example.HellowWorld;

import com.h2example.HellowWorld.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService  todoService;

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable long id)
    {
        try{
            Todo gotTodo=todoService.getTodoById(id);
            return new ResponseEntity<>(gotTodo, HttpStatus.OK);
        }
        catch(RuntimeException e)
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Todo>> getTodoall()
    {
        try{
            List<Todo> gotTodos=todoService.getAllTodos();
            return new ResponseEntity<List<Todo>>(gotTodos, HttpStatus.OK);
        }
        catch(RuntimeException e)
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoService.updateTodo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    void deleteTodoById(@PathVariable long id)
    {
        todoService.deleteTodoById(id);
    }


    @DeleteMapping("/deleteAll")
    void deleteAll()
    {
        todoService.deleteAllTodos();
    }



//    @GetMapping("/get")
//    String getTodo(){
//        todoService.getTodo();
//        return "Get Todo list";
//    }
//
//    @GetMapping("/{id}")
//    String getTodoById(@PathVariable int id)
//    {
//        return "Todo by Id "+id;
//    }
//
//    //Request Parms
//    @GetMapping("")
//    String getTodoByIdParam(@RequestParam(name="todoId") long id)
//    {
//        return "Todo by Id "+id;
//    }
//
////    @GetMapping("/create")
////    String createUser(@RequestParam String userName ,@RequestParam String password)
////    {
////        return "Todo with user name="+userName+" and "+"password="+password;
////    }
//
//    @PostMapping("/create")
//    String createUser(@RequestBody String userName)
//    {
//        return "Todo with user name="+userName;
//    }
//
//    @PutMapping("/update/{id}")
//    String UpdateTodoById(@PathVariable int id)
//    {
//        return "Todo by Id "+id;
//    }
//
//    @DeleteMapping("/delete/{id}")
//    String deleteTodoById(@PathVariable int id)
//    {
//        return "Todo by Id "+id;
//    }


}
