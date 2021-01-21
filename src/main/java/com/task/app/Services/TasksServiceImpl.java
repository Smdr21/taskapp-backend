package com.task.app.Services;

import com.task.app.Models.Task;
import com.task.app.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TasksServiceImpl implements ITasksService{

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public Task getTask(int id) {
        Optional<Task> task = tasksRepository.findById(id);

        if(task.isPresent()){
            return task.get();
        }
        else{

            return null;
        }
    }
    @Override
    public void createTask(Task task) {

        if(new Date(System.currentTimeMillis()).before(task.getDateDue())){
            task.setActive(true);
        }
        else{
            task.setActive(false);
        }
        task.setDateCreated(new Date(System.currentTimeMillis()));
        tasksRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
        /*Optional<Task> optionalTask =tasksRepository.findById(task.getId());
        if(optionalTask.isPresent()){

        }
        */
    }
    @Override
    public void deleteTask(int id) {
        tasksRepository.deleteById(id);
    }
}
