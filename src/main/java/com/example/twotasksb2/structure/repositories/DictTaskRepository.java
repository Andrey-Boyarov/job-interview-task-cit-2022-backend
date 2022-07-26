package com.example.twotasksb2.structure.repositories;

import com.example.twotasksb2.structure.entities.DictTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DictTaskRepository extends JpaRepository<DictTask, Long> {
    DictTask findByCode(Long code);
}
