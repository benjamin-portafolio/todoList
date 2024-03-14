package com.alienexplorer.app.rest.Controller;

import com.alienexplorer.app.rest.Model.Task;
import com.alienexplorer.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/")
    public String holaMundo(){
        return "Hola Mundo";
    }

    @GetMapping(value = "/task")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    @PostMapping(value = "savetask")
    public String saveTask (@RequestBody Task task){
        todoRepository.save(task);
        return "Saved task";
    }
}
