package com.task.app.Repository;

import com.task.app.Models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task,Integer> {

    @Query(value = "select * from tasks where date_due >=now() and date_due < curdate() + interval + 1 day", nativeQuery = true)
    List<Task> findTodaysTasks();

}
