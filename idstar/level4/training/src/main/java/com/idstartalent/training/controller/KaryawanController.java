package com.idstartalent.training.controller;


import com.idstartalent.training.dto.karyawan.KaryawanRq;
import com.idstartalent.training.dto.karyawan.KaryawanUpdateRq;
import com.idstartalent.training.model.GenericResponse;
import com.idstartalent.training.repository.KaryawanTrainingRepository;
import com.idstartalent.training.repository.KaryawanRepository;
import com.idstartalent.training.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class KaryawanController {

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    KaryawanService karyawanService;

    @Autowired
    KaryawanTrainingRepository detailKaryawanRepository;

    @PostMapping("/v1/idstar/karyawan/save")
    public ResponseEntity<Object> saveKaryawan(@RequestBody KaryawanRq karyawanRq){

        GenericResponse response = karyawanService.saveKaryawan(karyawanRq);

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PutMapping("/v1/idstar/karyawan/update")
    public ResponseEntity<Object>  updateKaryawan(@RequestBody KaryawanUpdateRq karyawan){
        GenericResponse response = karyawanService.updateKaryawan(karyawan);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/v1/idstar/karyawan/list")
    public ResponseEntity<Object> getListKaryawan(){
        GenericResponse response = karyawanService.getListKaryawan();
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/v1/idstar/karyawan/{id}")
    public ResponseEntity<Object> getKaryawanById(@PathVariable int id){
        GenericResponse response = karyawanService.findById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/v1/idstar/karyawan/delete/{id}")
    public ResponseEntity<Object> deleteKaryawan(@PathVariable("id") int id){
        GenericResponse response = karyawanService.deleteById(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
