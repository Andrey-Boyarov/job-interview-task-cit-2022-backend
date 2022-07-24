package com.example.twotasksb2.utils.pojos;

import com.example.twotasksb2.utils.TaskPojo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * POJO for input for task one (arrays)
 */
@NoArgsConstructor
@Getter
public class InputOneRequestPojo implements TaskPojo {
    private CurrentDataTaskOne currentData;

    public List<Option> getOne(){
        return currentData.getOne();
    }

    public List<Option> getTwo(){
        return currentData.getTwo();
    }
}