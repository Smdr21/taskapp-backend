package com.task.app.Services;

import com.task.app.Models.Task;

public interface ITasksService {
    public abstract Task getTask(int id);
    public abstract void createTask(Task task);
    public abstract void updateTask(Task task);
    public abstract void deleteTask(int id);

}
