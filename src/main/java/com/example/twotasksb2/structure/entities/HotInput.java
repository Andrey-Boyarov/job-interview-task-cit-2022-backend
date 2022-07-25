package com.example.twotasksb2.structure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "hot_input")
@Getter
public class HotInput {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_code", referencedColumnName = "code")
    private DictTask task;

    private String input;

    public HotInput(DictTask task, String input){
        this.task = task;
        this.input = input;
    }
}
