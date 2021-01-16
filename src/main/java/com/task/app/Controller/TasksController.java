package com.task.app.Controller;

import com.task.app.Models.Task;
import com.task.app.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TasksController {
    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/")
    public String home(){
        Task task = new Task("Go Shopping",
                "I need to buy fruits",
                "This is an actual category",new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()));
        tasksRepository.save(task);
        return "<h1>hello</h1>";
    }
}
