package com.example.twotasksb2.utils.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * As simple option as possible
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Option {
    private Long value;
    private String label;
}
