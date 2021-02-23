package com.task.app.Controller;

import com.task.app.Models.Task;
import com.task.app.Models.TaskPage;
import com.task.app.Repository.TasksRepository;
import com.task.app.Services.TasksServiceImpl;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/")
public class TasksController {

    @Autowired
    private TasksServiceImpl tasksService;

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> home(@RequestParam int pageNumber){
        TaskPage taskPages = new TaskPage(pageNumber);
        List<Task> tasks =tasksService.getTasks(taskPages);
        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<Task>> home(){
        List<Task> tasks= tasksService.getTodayAndTomorrowTasks();
        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<List<Task>>(tasks,HttpStatus.OK);
        }
    }
    @PostMapping("/newtask")
    public ResponseEntity<?> newTask(@RequestBody Task task){

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
    public ResponseEntity<?> DeleteTask(@PathVariable int id){
        tasksService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/edittask/{id}")
    public ResponseEntity<?> updateTask(@RequestBody Task task, @PathVariable int id){
        try {
            tasksService.updateTask(task,id);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
