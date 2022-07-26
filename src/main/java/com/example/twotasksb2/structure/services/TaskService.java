package com.example.twotasksb2.structure.services;

import com.example.twotasksb2.structure.entities.DictTask;
import com.example.twotasksb2.structure.repositories.DictTaskRepository;
import com.example.twotasksb2.tasks.TaskEnum;
import com.example.twotasksb2.tasks.TaskFactory;
import com.example.twotasksb2.utils.AdapterUtils;
import com.example.twotasksb2.utils.pojos.Option;
import com.example.twotasksb2.utils.TaskPojo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for interactions with tasks
 */
@Service
@AllArgsConstructor
public class TaskService {
    private final DictTaskRepository dictTaskRepository;
    private final TaskFactory taskFactory;

    /**
     * Get all existing tasks as options (Option)
     */
    public List<Option> getTasks(){
        return dictTaskRepository.findAll().stream().map(t -> new Option(t.getCode(), t.getLabel())).collect(Collectors.toList());
    }

    /**
     * Get type of input assigned to task
     */
    public ResponseEntity<Long> getInputType(Long id){
        Long res = getInputTypeById(id);
        return res == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * Get answer to our task and input
     */
    public String calculate(Long taskCode, TaskPojo pojo){
        return taskFactory.create(taskCode, pojo).calculate();
    }

    /**
     * Get answer to our task and input
     */
    public String calculate(Long taskCode, String json){
        if (TaskEnum.ARRAYS.getCode().equals(taskCode)) return calculate(taskCode, AdapterUtils.getPojoForTaskOne(json));
        if (TaskEnum.MAGIC_SQUARE.getCode().equals(taskCode)) return calculate(taskCode, AdapterUtils.getPojoForTaskTwo(json));
        return "Something went wrong during calculation";
    }

    private Long getInputTypeById(Long id){
        return dictTaskRepository.findById(id).map(DictTask::getInputType).orElse(null);
    }
}
