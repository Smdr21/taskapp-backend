package com.task.app.Services;

import com.task.app.Models.Task;
import com.task.app.Models.TaskPage;
import com.task.app.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TasksServiceImpl implements ITasksService{

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public List<Task> getTasks(TaskPage taskPage) {
        Sort sort = Sort.by(taskPage.getSortDirection(),taskPage.getSortBy());
        Pageable pageable = PageRequest.of(taskPage.getPageNumber(),taskPage.getPageSize(),sort);
        Page<Task> page = tasksRepository.findAll(pageable);
        return page.getContent();
    }
    @Override
    public List<Task> getTodayAndTomorrowTasks() {
        return tasksRepository.findTodaysTasks();
    }


    @Override
    public Task getTask(int id) {
        Optional<Task> task = tasksRepository.findById(id);

        return task.orElse(null);
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
    public void updateTask(Task task, int id) {
        Task taskToUpdate = tasksRepository.getOne(id);
        taskToUpdate.setDateDue(task.getDateDue());
        taskToUpdate.setCategory(task.getCategory());
        taskToUpdate.setName(task.getName());
        taskToUpdate.setDescription(task.getDescription());

        tasksRepository.save(taskToUpdate);
    }
    @Override
    public void deleteTask(int id) {
        tasksRepository.deleteById(id);
    }
}
