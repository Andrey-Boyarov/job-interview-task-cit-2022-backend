package com.example.twotasksb2.structure.controllers;

import com.example.twotasksb2.structure.services.TaskService;
import com.example.twotasksb2.tasks.TaskEnum;
import com.example.twotasksb2.utils.pojos.InputOneRequestPojo;
import com.example.twotasksb2.utils.pojos.InputTwoRequestPojo;
import com.example.twotasksb2.utils.pojos.Option;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controller to interact with tasks
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    /**
     *  /tasks/getTasks
     *
     *  Get all existing tasks
     *  @return task labels with codes
     */
    @GetMapping("/getTasks")
    public List<Option> getTasks(){
        return taskService.getTasks();
    }

    /**
     *  /tasks/getInputType/{id}
     *
     *  Get type of input suitable for task
     *  @return type of input for this task
     */
    @GetMapping("/getInputType/{id}")
    public ResponseEntity<Long> getInputType(@PathVariable Long id){
        return taskService.getInputType(id);
    }

    /**
     *  /tasks/calculate/1
     *
     *  Get answer for input and task one
     *  @return answer
     */
    @PostMapping("/calculate/1")
    public ResponseEntity<String> calculateTaskOne(
            @RequestBody InputOneRequestPojo pojo
            ){
        Long taskId = TaskEnum.ARRAYS.getCode();
        return new ResponseEntity<>(taskService.calculate(taskId, pojo), HttpStatus.OK);
    }

    /**
     *  /tasks/calculate/2
     *
     *  Get answer for input and task two
     *  @return answer
     */
    @PostMapping("/calculate/2")
    public ResponseEntity<String> calculateTaskTwo(
            @RequestBody InputTwoRequestPojo pojo
            ){
        Long taskId = TaskEnum.MAGIC_SQUARE.getCode();
        return new ResponseEntity<>(taskService.calculate(taskId, pojo), HttpStatus.OK);
    }
}
