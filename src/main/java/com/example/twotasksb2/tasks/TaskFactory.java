package com.example.twotasksb2.tasks;

import com.example.twotasksb2.utils.TaskPojo;
import com.example.twotasksb2.utils.pojos.InputOneRequestPojo;
import com.example.twotasksb2.utils.pojos.InputTwoRequestPojo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskFactory {
    public Task create(Long id, TaskPojo input){
        if (TaskEnum.ARRAYS.getCode().equals(id)) {
            return new TaskOne((InputOneRequestPojo) input);
        } else if (TaskEnum.MAGIC_SQUARE.getCode().equals(id)) {
            return new TaskTwo((InputTwoRequestPojo) input);
        }
        new NoSuchTaskCodeException("No such code for task exists").printStackTrace();
        return null;
    }

    private static class NoSuchTaskCodeException extends Exception{
        public NoSuchTaskCodeException(String message){
            super(message);
        }
    }
}
