package com.example.twotasksb2.utils.pojos;

import com.example.twotasksb2.utils.TaskPojo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * POJO for input for task one (arrays)
 */
@Getter
@NoArgsConstructor
public class InputOneRequestPojo implements TaskPojo {
    @JsonProperty("currentData")
    private CurrentDataTaskOne currentData;

    public List<Option> getOne(){
        return currentData.getOne();
    }

    public List<Option> getTwo(){
        return currentData.getTwo();
    }

    @Getter
    public static class CurrentDataTaskOne {
        @JsonProperty("one")
        private List<Option> one;
        @JsonProperty("two")
        private List<Option> two;
    }
}