package com.idstartalent.training.controller;

import com.idstartalent.training.dto.training.TrainingRq;
import com.idstartalent.training.dto.training.TrainingUpdateRq;
import com.idstartalent.training.model.GenericResponse;
import com.idstartalent.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/v1/idstar/training/list")
    public ResponseEntity<Object> getListTraining(){
        GenericResponse response = trainingService.getListTraining();
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @PostMapping("/v1/idstar/training/save")
    public ResponseEntity<Object> saveTraining(@RequestBody TrainingRq trainingRq){
        GenericResponse response = trainingService.saveTraining(trainingRq);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PutMapping("/v1/idstar/training/update")
    public ResponseEntity<Object> updateTraining(@RequestBody TrainingUpdateRq trainingUpdateRq){
        GenericResponse response = trainingService.updateTraining(trainingUpdateRq);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/v1/idstar/training/{id}")
    public ResponseEntity<Object> getTrainingById(@PathVariable("id") int id){
        GenericResponse response = trainingService.findById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/v1/idstar/training/delete/{id}")
    public ResponseEntity<Object> deleteTraining(@PathVariable("id") int id){
        GenericResponse response = trainingService.deleteById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
