package com.example.twotasksb2.structure.controllers;

import com.example.twotasksb2.structure.services.HotInputService;
import com.example.twotasksb2.utils.pojos.Option;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controller for operations with stored inputs
 */
@RestController
@AllArgsConstructor
@RequestMapping("/hotInput")
public class HotInputController {
    private final HotInputService hotInputService;

    /**
     *  /hotInput/save/{taskCode}
     *
     *  Save input in db
     */
    @PostMapping("/save/{taskCode}")
    public ResponseEntity<HttpStatus> save(
            @PathVariable Long taskCode,
            @RequestBody String input
    ){
        hotInputService.createAndSave(taskCode, input);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *  /hotInput/getByTask/{taskCode}
     *
     *  Get inputs by task
     *  @return every saved input that belongs to task
     */
    @GetMapping("/getByTask/{taskCode}")
    public ResponseEntity<List<Option>> getByTask(@PathVariable Long taskCode){
        return new ResponseEntity<>(hotInputService.getOptionsByTaskCode(taskCode), HttpStatus.OK);
    }

    /**
     *  /hotInput/delete/{inputId}
     *
     *  Delete input
     */
    @DeleteMapping("/delete/{inputId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long inputId){
        hotInputService.delete(inputId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *  /hotInput/calculate/{inputId}
     *
     *  @return answer for this input
     */
    @GetMapping("/calculate/{inputId}")
    public ResponseEntity<String> calculate(@PathVariable Long inputId){
        return new ResponseEntity<>(hotInputService.calculate(inputId), HttpStatus.OK);
    }
}
