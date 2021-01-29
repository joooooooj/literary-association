package com.la.controller.registration;

import camundajar.impl.scala.util.parsing.json.JSON;
import com.la.dto.FormFieldsDTO;
import com.la.dto.FormSubmissionDTO;
import com.la.service.GenreService;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/auth/registration")
public class RegistrationAuthController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private GenreService genreService;

    // 1. KORAK / DOBAVLJANJE FORME REGISTRACIJE SA ZANROVIMA
    @GetMapping(value = "/user-input-details")
    public ResponseEntity<FormFieldsDTO> getUserInputDataFormFieldsDTO() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_registration");
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list().get(0);
        TaskFormData taskFormData = formService.getTaskFormData(task.getId());
        List<FormField> formFields = taskFormData.getFormFields();

        Object citiesAndCountries = runtimeService.getVariables(task.getExecutionId()).get("citiesAndCountries");
        String citiesAndCountriesString = String.valueOf(citiesAndCountries);

        formFields.get(5).getProperties().put("options", citiesAndCountriesString);

        Object genres = runtimeService.getVariables(task.getExecutionId()).get("genres");
        String genresString = String.valueOf(genres);

        formFields.get(6).getProperties().put("options", genresString);

        return new ResponseEntity<>(new FormFieldsDTO(task.getId(), formFields, processInstance.getId()), HttpStatus.OK);
    }

    // 2. KORAK / SLANJE FORME REGISTRACIJE / AKO JE WRITER ILI OBICAN READER MAIL / AKO JE BETA FORMA ZANROVA
    @PostMapping(value = "/{taskId}/{isWriter}/{isBeta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registration(@RequestBody List<FormSubmissionDTO> formSubmissionDTOS, @PathVariable("taskId") String taskId,
                                          @PathVariable("isWriter") Boolean isWriter, @PathVariable("isBeta") Boolean isBeta) {
        System.out.println(taskId);
        HashMap<String, Object> map = this.mapFormItemsToMap(formSubmissionDTOS);
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, "registration", formSubmissionDTOS);

        runtimeService.setVariable(processInstanceId, "is_writer", isWriter);
        runtimeService.setVariable(processInstanceId, "is_beta", isBeta);

        formService.submitTaskForm(taskId, map);
        return new ResponseEntity<>(Collections.singletonMap("processInstanceId", processInstanceId), HttpStatus.OK);
    }

    // 3. KORAK / DOBAVLJANJE FORME ZANROVA UKOLIKO JE BETA READER
    @GetMapping(value = "/reader-preferences/{processId}")
    public ResponseEntity<FormFieldsDTO> getReaderPreferences(@PathVariable("processId") String processId) {
        Task task = taskService.createTaskQuery().processInstanceId(processId).list().get(0);
        TaskFormData taskFormData = formService.getTaskFormData(task.getId());
        List<FormField> formFields = taskFormData.getFormFields();

//        Object genres = runtimeService.getVariables(task.getExecutionId()).get("genres");
        Object genres = genreService.findAll();
        String genresString = String.valueOf(genres);

        formFields.get(0).getProperties().put("options", genresString);
        return new ResponseEntity<>(new FormFieldsDTO(task.getId(), formFields, processId), HttpStatus.OK);
    }

    // 4. KORAK / SLANJE BETA READER ODABRANIH ZANROVA
    @PostMapping(value = "/reader-wanted-genres/{taskId}")
    public ResponseEntity<?> readerWantedGenres(@RequestBody List<FormSubmissionDTO> formSubmissionDTOS, @PathVariable("taskId") String taskId) {
        System.out.println(taskId);
        HashMap<String, Object> map = this.mapFormItemsToMap(formSubmissionDTOS);
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, "betaReaderWantedGenres", formSubmissionDTOS);

        formService.submitTaskForm(taskId, map);
        return new ResponseEntity<>(Collections.singletonMap("processInstanceId", processInstanceId), HttpStatus.OK);
    }

    // 5. KORAK / AKTIVIRANJE KORISNIKA EMAILOM
    @GetMapping(value = "/activate-user/{processId}")
    public ResponseEntity<?> activateUser(@PathVariable("processId") String processId) {
        MessageCorrelationResult result = runtimeService.createMessageCorrelation("activateUserMessage")
                .processInstanceId(processId)
                .correlateWithResult();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    private HashMap<String, Object> mapFormItemsToMap(List<FormSubmissionDTO> formSubmissionDTOS) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        formSubmissionDTOS.forEach(fi -> {
            map.put(fi.getFieldId(), fi.getFieldValue());
        });
        return map;
    }
}
