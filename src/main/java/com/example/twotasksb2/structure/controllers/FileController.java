package com.example.twotasksb2.structure.controllers;

import com.example.twotasksb2.structure.services.TaskService;
import com.example.twotasksb2.tasks.TaskEnum;
import com.example.twotasksb2.utils.AdapterUtils;
import com.example.twotasksb2.utils.TaskPojo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@RestController
@AllArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final TaskService taskService;

    @PostMapping("/upload/{taskCode}")
    public ResponseEntity<String> uploadData(@PathVariable Long taskCode, @RequestParam("file") MultipartFile file) throws Exception {
        if (file == null) throw new RuntimeException("You must select a file for uploading");
        String json = new String (file.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        TaskPojo pojo = null;
        if (TaskEnum.ARRAYS.getCode().equals(taskCode)) pojo = AdapterUtils.getPojoForTaskOne(json);
        if (TaskEnum.MAGIC_SQUARE.getCode().equals(taskCode)) pojo = AdapterUtils.getPojoForTaskTwo(json);
        String ans = "Input:\n"
                + AdapterUtils.beautyVersion(pojo)
                + "\n\nResult:\n" + taskService.calculate(taskCode, json);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> download(@RequestBody String pojo) {
        byte[] data = pojo.getBytes(StandardCharsets.UTF_8);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_PLAIN);
        header.setContentLength(data.length);
        header.set("Content-Disposition", "attachment; filename=" + "Input.txt");
        return new ResponseEntity<>(data, header, HttpStatus.OK);
    }
}
