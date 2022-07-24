package com.example.twotasksb2.structure.controllers;

import com.example.twotasksb2.structure.services.TaskService;
import com.example.twotasksb2.utils.pojos.InputOneRequestPojo;
import com.example.twotasksb2.utils.pojos.Option;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/calculate/1")
    public ResponseEntity<String> calculate(
            @RequestBody InputOneRequestPojo pojo
            ){
        Long taskId = 2L;
        return taskService.calculate(taskId, pojo);
    }
}
