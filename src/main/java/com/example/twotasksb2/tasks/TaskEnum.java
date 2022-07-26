package com.example.twotasksb2.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum with task code
 */
@AllArgsConstructor
public enum TaskEnum {
    ARRAYS(1L), MAGIC_SQUARE(2L);

    @Getter
    private final Long code;
}
