package com.example.twotasksb2.structure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *  Dictionary for tasks
 */
@Table(name = "dict_task")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DictTask implements Serializable {
    @Id
    private Long id;

    private String label;

    private Long code;

    private Long inputType;
}
