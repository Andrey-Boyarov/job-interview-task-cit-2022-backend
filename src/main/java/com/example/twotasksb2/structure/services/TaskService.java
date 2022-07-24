package com.example.twotasksb2.structure.services;

import com.example.twotasksb2.structure.entities.DictTask;
import com.example.twotasksb2.structure.repositories.DictTaskRepository;
import com.example.twotasksb2.utils.Option;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final DictTaskRepository dictTaskRepository;

    public List<Option> getTasks(){
        return dictTaskRepository.findAll().stream().map(t -> new Option(t.getCode(), t.getLabel())).collect(Collectors.toList());
    }
}
