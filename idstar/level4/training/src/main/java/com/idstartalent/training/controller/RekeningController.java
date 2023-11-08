package com.idstartalent.training.controller;

import com.idstartalent.training.dto.rekening.RekeningRq;
import com.idstartalent.training.dto.rekening.RekeningUpdateRq;
import com.idstartalent.training.model.GenericResponse;
import com.idstartalent.training.model.Rekening;
import com.idstartalent.training.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RekeningController {

    @Autowired
    RekeningService rekeningService;


    @GetMapping("/v1/idstar/rekening/list")
    public ResponseEntity<Object> getListRekening(){
        GenericResponse response = rekeningService.getListRekening();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping("/v1/idstar/rekening/save")
    public ResponseEntity<Object> saveRekening(@RequestBody RekeningRq rekeningRq){
        GenericResponse response = rekeningService.saveRekening(rekeningRq);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PutMapping("/v1/idstar/rekening/update")
    public ResponseEntity<Object> updateRekening(@RequestBody RekeningUpdateRq rekeningUpdateRq){
        GenericResponse response = rekeningService.updateRekening(rekeningUpdateRq);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/v1/idstar/rekening/{id}")
    public ResponseEntity<Object> getRekeningById(@PathVariable("id") int id){
        GenericResponse response = rekeningService.findById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/v1/idstar/rekening/delete/{id}")
    public ResponseEntity<Object> deleteRekening(@PathVariable("id") int id){
        GenericResponse response = rekeningService.deleteById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
