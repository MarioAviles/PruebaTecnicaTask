package com.example.PruebaTecnica.repository;

import com.example.PruebaTecnica.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
