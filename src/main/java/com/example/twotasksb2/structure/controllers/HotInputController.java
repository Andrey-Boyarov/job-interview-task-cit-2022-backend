package com.example.twotasksb2.structure.controllers;

import com.example.twotasksb2.structure.services.HotInputService;
import com.example.twotasksb2.utils.pojos.Option;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hotInput")
public class HotInputController {
    private final HotInputService hotInputService;

    @PostMapping("/save/{taskCode}")
    public ResponseEntity<HttpStatus> save(
            @PathVariable Long taskCode,
            @RequestBody String input
    ){
        hotInputService.createAndSave(taskCode, input);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getByTask/{taskCode}")
    public ResponseEntity<List<Option>> getByTask(@PathVariable Long taskCode){
        return new ResponseEntity<>(hotInputService.getOptionsByTaskCode(taskCode), HttpStatus.OK);
    }
}
