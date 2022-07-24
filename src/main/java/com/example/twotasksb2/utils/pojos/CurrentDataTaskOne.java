package com.example.twotasksb2.utils.pojos;

import lombok.Getter;

import java.util.List;

/**
 * POJO for currentData parameter in InputOneRequestPojo
 */
@Getter
public class CurrentDataTaskOne {
    private List<Option> one;
    private List<Option> two;
}
