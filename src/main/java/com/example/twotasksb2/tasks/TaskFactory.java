package com.example.twotasksb2.tasks;

import com.example.twotasksb2.structure.repositories.DictTaskRepository;
import com.example.twotasksb2.utils.TaskPojo;
import com.example.twotasksb2.utils.pojos.InputOneRequestPojo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskFactory {
    private final DictTaskRepository dictTaskRepository;

    public Task create(Long id, TaskPojo input){
        if (TaskEnum.ARRAYS.getCode().equals(id)) {
            return new TaskOne((InputOneRequestPojo) input);
        }
//        else if (TaskEnum.MAGIC_SQUARE.getCode().equals(id)) {
//            return null; //todo TaskTwo
//        }
        new TaskFactoryNoSuchTaskCodeException("No such code for task exists").printStackTrace();
        return null;
    }


    private static class TaskFactoryNoSuchTaskCodeException extends Exception{
        public TaskFactoryNoSuchTaskCodeException(String message){
            super(message);
        }
    }
}
