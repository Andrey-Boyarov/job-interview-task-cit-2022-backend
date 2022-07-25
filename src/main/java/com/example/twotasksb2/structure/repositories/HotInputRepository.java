package com.example.twotasksb2.structure.repositories;

import com.example.twotasksb2.structure.entities.DictTask;
import com.example.twotasksb2.structure.entities.HotInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotInputRepository extends JpaRepository<HotInput, Long> {
    List<HotInput> findAllByTask(DictTask task);
}
