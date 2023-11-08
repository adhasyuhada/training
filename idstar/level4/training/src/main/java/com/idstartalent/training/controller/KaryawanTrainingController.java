package com.idstartalent.training.controller;

import com.idstartalent.training.dto.karyawantraining.KaryawanTrainingRq;
import com.idstartalent.training.dto.karyawantraining.KaryawanTrainingUpdateRq;
import com.idstartalent.training.model.GenericResponse;
import com.idstartalent.training.model.KaryawanTraining;
import com.idstartalent.training.service.KaryawanTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KaryawanTrainingController {

    @Autowired
    KaryawanTrainingService karyawanTrainingService;

    @GetMapping("/v1/idstar/karyawantraining/list")
    public ResponseEntity<Object> getListKaryawanTraining(){
        GenericResponse response = karyawanTrainingService.getListKaryawanTraining();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }
    @PostMapping("/v1/idstar/karyawantraining/save")
    public ResponseEntity<Object> saveKaryawanTraining(@RequestBody KaryawanTrainingRq karyawanTrainingRq){
        GenericResponse response = karyawanTrainingService.saveKaryawanTraining(karyawanTrainingRq);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PutMapping("/v1/idstar/karyawantraining/update")
    public ResponseEntity<Object> updateKaryawanTraining(@RequestBody KaryawanTrainingUpdateRq karyawanTrainingUpdateRq){
        GenericResponse response = karyawanTrainingService.updateKaryawanTraining(karyawanTrainingUpdateRq);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/v1/idstar/karyawantraining/{id}")
    public ResponseEntity<Object> getKaryawanTrainingById(@PathVariable("id") int id){
        GenericResponse response = karyawanTrainingService.findById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/v1/idstar/karyawantraining/delete/{id}")
    public ResponseEntity<Object> deleteKaryawanTrainingById(@PathVariable("id")int id){
        GenericResponse response = karyawanTrainingService.deleteById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
