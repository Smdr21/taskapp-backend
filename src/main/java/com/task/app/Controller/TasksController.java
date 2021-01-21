package com.task.app.Controller;

import com.task.app.Models.Task;
import com.task.app.Repository.TasksRepository;
import com.task.app.Services.TasksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/")
public class TasksController {
    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private TasksServiceImpl tasksService;

    @GetMapping("/")
    public String home(){/*
        Task task = new Task("Go Shopping",
                "I need to buy fruits",
                "This is an actual category",new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()));
        tasksRepository.save(task);
        */
        return "<h1>hello</h1>";

    }
    @PostMapping("/newtask")
    public ResponseEntity<?> newtask(@RequestBody Task task){

        System.out.println(task.toString());
        tasksService.createTask(task);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> task(@PathVariable int id){
        Task newTask = tasksService.getTask(id);
        if(newTask == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Task>(newTask,HttpStatus.OK);
        }
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> Deletetask(@PathVariable int id){
        tasksService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
