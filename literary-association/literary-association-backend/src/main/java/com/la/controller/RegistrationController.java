package com.la.controller;

import com.la.dto.FormDto;
import com.la.dto.FormFieldDto;
import com.la.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("register")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormDto> get() {
        try {
            FormDto formDto = registrationService.getFormDto();

            return new ResponseEntity<>(formDto, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/submit/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> submit(@RequestBody List<FormFieldDto> dto, @PathVariable String taskId){

        try {
            registrationService.submitFormDto(dto, taskId);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
