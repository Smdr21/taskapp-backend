package com.task.app.Repository;

import com.task.app.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task,Integer> {
}
