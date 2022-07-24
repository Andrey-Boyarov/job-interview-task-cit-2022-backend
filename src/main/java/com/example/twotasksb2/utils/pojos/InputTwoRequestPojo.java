package com.example.twotasksb2.utils.pojos;

import com.example.twotasksb2.utils.TaskPojo;
import lombok.Getter;

import java.util.List;

/**
 * POJO for input for task two (magic square)
 */
@Getter
public class InputTwoRequestPojo implements TaskPojo {
    private List<List<Long>> currentData;
}
