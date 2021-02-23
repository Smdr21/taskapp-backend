package com.task.app.Services;

import com.task.app.Models.Task;
import com.task.app.Models.TaskPage;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Max;
import java.awt.print.Pageable;
import java.util.List;

public interface ITasksService {
    public abstract List<Task> getTasks(TaskPage taskPage);
    public abstract List<Task> getTodayAndTomorrowTasks();
    public abstract Task getTask(int id);
    public abstract void createTask(Task task);
    public abstract void updateTask(Task task,int id);
    public abstract void deleteTask(int id);

}
