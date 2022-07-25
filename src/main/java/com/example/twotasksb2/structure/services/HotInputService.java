package com.example.twotasksb2.structure.services;

import com.example.twotasksb2.structure.repositories.HotInputRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HotInputService {
    private final HotInputRepository hotInputRepository;
}
