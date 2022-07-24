package com.example.twotasksb2.tasks;

import com.example.twotasksb2.structure.entities.DictTask;
import com.example.twotasksb2.utils.pojos.InputOneRequestPojo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskOne implements Task{
    private final InputOneRequestPojo input;
    @Override
    public String calculate() {
        return "calculated";
    }
}
