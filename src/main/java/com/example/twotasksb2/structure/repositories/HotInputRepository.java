package com.example.twotasksb2.structure.repositories;

import com.example.twotasksb2.structure.entities.HotInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotInputRepository extends JpaRepository<HotInput, Long> {
}
