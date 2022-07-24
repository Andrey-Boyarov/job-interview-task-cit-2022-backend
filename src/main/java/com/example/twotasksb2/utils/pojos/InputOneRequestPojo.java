package com.example.twotasksb2.utils.pojos;

import com.example.twotasksb2.utils.TaskPojo;
import lombok.Getter;

import java.util.List;

/**
 * POJO for input for task one (arrays)
 */

@Getter
public class InputOneRequestPojo implements TaskPojo {
    private CurrentData currentData;

    @Getter
    private static class CurrentData {
        private List<Option> one;
        private List<Option> two;
    }
}