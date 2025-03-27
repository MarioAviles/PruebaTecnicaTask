package com.example.PruebaTecnica.controller;

import com.example.PruebaTecnica.entity.Task;
import com.example.PruebaTecnica.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public ResponseEntity<?> getAllTasks() { //para poder devolver distintos tipos de datos

        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build(); //en caso de que este vacío, devuelve este mensaje
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    //probar a quitar valores nulos
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task newTask) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (newTask.getTitle() != null) {
            task.setTitle(newTask.getTitle());
        }
        if (newTask.getDescription() != null) {
            task.setDescription(newTask.getDescription());
        }
        task.setCompleted(newTask.isCompleted());

        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
