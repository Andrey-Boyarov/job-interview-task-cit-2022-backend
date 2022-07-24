package com.example.twotasksb2.structure.services;

import com.example.twotasksb2.structure.entities.DictTask;
import com.example.twotasksb2.structure.repositories.DictTaskRepository;
import com.example.twotasksb2.tasks.TaskFactory;
import com.example.twotasksb2.utils.pojos.Option;
import com.example.twotasksb2.utils.TaskPojo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final DictTaskRepository dictTaskRepository;
    private final TaskFactory taskFactory;

    public List<Option> getTasks(){
        return dictTaskRepository.findAll().stream().map(t -> new Option(t.getCode(), t.getLabel())).collect(Collectors.toList());
    }

    public ResponseEntity<Long> getInputType(Long id){
        Long res = getInputTypeById(id);
        return res == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<String> calculate(Long taskId, TaskPojo pojo){
        return new ResponseEntity<>(taskFactory.create(taskId, pojo).calculate(), HttpStatus.OK);
    }

    private Long getInputTypeById(Long id){
        return dictTaskRepository.findById(id).map(DictTask::getInputType).orElse(null);
    }
}
