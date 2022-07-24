package com.example.twotasksb2.utils.pojos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * POJO for currentData parameter in InputOneRequestPojo
 */
@NoArgsConstructor
@Getter
public class CurrentDataTaskOne {
    private List<Option> one;
    private List<Option> two;
}
