package com.example.twotasksb2.structure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hot_input")
@Getter
@Setter
public class HotInput {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_code", referencedColumnName = "code")
    private DictTask taskCode;

    private String input;
}
