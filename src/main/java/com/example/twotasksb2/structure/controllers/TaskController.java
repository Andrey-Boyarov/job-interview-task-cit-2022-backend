package com.example.twotasksb2.structure.controllers;

import com.example.twotasksb2.structure.services.TaskService;
import com.example.twotasksb2.utils.Option;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/getTasks")
    public List<Option> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/getInputType/{id}")
    public ResponseEntity<Long> getInputType(@PathVariable Long id){
        return taskService.getInputType(id);
    }
}
