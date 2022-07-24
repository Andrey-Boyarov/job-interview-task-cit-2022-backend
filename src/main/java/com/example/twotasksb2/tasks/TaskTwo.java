package com.example.twotasksb2.tasks;

import com.example.twotasksb2.utils.pojos.InputTwoRequestPojo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskTwo implements Task{
    private final InputTwoRequestPojo input;

    @Override
    public String calculate(){
        return "calculated task two";
    }
}
