package com.h2example.HellowWorld;

import com.h2example.HellowWorld.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

//CRUD -- Create Read Update Delete
@Component
public interface TodoRepository extends JpaRepository<Todo, Long> {


}
