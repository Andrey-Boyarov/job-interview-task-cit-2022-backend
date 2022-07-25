package com.example.twotasksb2.structure.services;

import com.example.twotasksb2.structure.entities.HotInput;
import com.example.twotasksb2.structure.repositories.DictTaskRepository;
import com.example.twotasksb2.structure.repositories.HotInputRepository;
import com.example.twotasksb2.utils.pojos.Option;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotInputService {
    private final HotInputRepository hotInputRepository;
    private final DictTaskRepository dictTaskRepository;

    public HotInput createAndSave(Long taskCode, String input){
        return hotInputRepository.save(new HotInput(dictTaskRepository.findByCode(taskCode), input));
    }

    public List<Option> getOptionsByTaskCode(Long taskCode){
        return hotInputRepository.findAllByTask(dictTaskRepository.findByCode(taskCode)).stream()
                .map(t -> new Option(t.getId(), t.getInput())).collect(Collectors.toList());
    }
}
