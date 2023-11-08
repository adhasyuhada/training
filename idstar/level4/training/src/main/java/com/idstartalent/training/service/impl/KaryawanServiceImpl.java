package com.idstartalent.training.service.impl;

import com.idstartalent.training.dto.karyawan.KaryawanRq;
import com.idstartalent.training.dto.karyawan.KaryawanUpdateRq;
import com.idstartalent.training.model.DetailKaryawan;
import com.idstartalent.training.model.GenericResponse;
import com.idstartalent.training.model.Karyawan;
import com.idstartalent.training.repository.DetailKaryawanRepository;
import com.idstartalent.training.repository.KaryawanRepository;
import com.idstartalent.training.service.KaryawanService;
import com.idstartalent.training.util.Code;
import com.idstartalent.training.util.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class KaryawanServiceImpl implements KaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Autowired
    private DetailKaryawanRepository detailKaryawanRepository;

    @Override
    public GenericResponse getListKaryawan() {
        GenericResponse response = new GenericResponse();
        List<Karyawan> karyawanList = new ArrayList<>();
        try {
             karyawanList = karyawanRepository.findAll();
             log.info("GET LIST KARYAWAN");
        }catch (Exception e){
            log.error("GER LIST KARYAWAN ERROR");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setSuccess(karyawanList);
        return response;
    }

    @Override
    public GenericResponse saveKaryawan(KaryawanRq karyawanRq) {
        GenericResponse response = new GenericResponse();

        try {

            DetailKaryawan detailKaryawan = new DetailKaryawan();
            detailKaryawan.setCreatedDate(new Date());
            detailKaryawan.setNpwp(karyawanRq.getDetailKaryawan().getNpwp());
            detailKaryawan.setNik(karyawanRq.getDetailKaryawan().getNik());

            Karyawan karyawan = new Karyawan();
            karyawan.setAlamat(karyawanRq.getAlamat());
            karyawan.setDob(karyawanRq.getDob());
            karyawan.setNama(karyawanRq.getNama());
            karyawan.setCreatedDate(new Date());
            karyawan.setDetailKaryawan(detailKaryawan);
            karyawanRepository.save(karyawan);
            response.setSuccess(karyawan);
            log.info("SAVE KARYAWAN SUCCESS");
        }catch (Exception e){
            log.error("SAVE KARYAWAN ERROR");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


    @Override
    public GenericResponse updateKaryawan(KaryawanUpdateRq karyawanUpdateRq) {
        GenericResponse response = new GenericResponse();

        try {

            Optional<Karyawan> karyawan = karyawanRepository.findById(karyawanUpdateRq.getId());
            Optional<DetailKaryawan> detailKaryawan = detailKaryawanRepository.findById(karyawanUpdateRq.getDetailKaryawan().getId());

            if(karyawan.isPresent() && detailKaryawan.isPresent()){
                karyawan.get().setId(karyawanUpdateRq.getId());
                karyawan.get().setNama(karyawanUpdateRq.getNama());
                karyawan.get().setDob(karyawanUpdateRq.getDob());
                karyawan.get().setStatus(karyawanUpdateRq.getStatus());
                karyawan.get().setAlamat(karyawanUpdateRq.getAlamat());
                karyawan.get().setUpdatedDate(new Date());

                detailKaryawan.get().setId(karyawanUpdateRq.getDetailKaryawan().getId());
                detailKaryawan.get().setNik(karyawanUpdateRq.getDetailKaryawan().getNik());
                detailKaryawan.get().setNpwp(karyawanUpdateRq.getDetailKaryawan().getNpwp());
                detailKaryawan.get().setUpdatedDate(new Date());

                karyawan.get().setDetailKaryawan(detailKaryawan.get());

                karyawanRepository.save(karyawan.orElseThrow());
            }else {
                throw new NoSuchElementException("Karyawan or detail karyawan doesn't exist");
            }

            response.setSuccess(karyawan);
            log.info("UPDATE KARYAWAN SUCCESS");
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR UPDATE KARYAWAN {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("UPDATE KARYAWAN ERROR {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse findById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            Optional<Karyawan> karyawan = karyawanRepository.findById(id);
            response.setSuccess(karyawan.orElseThrow());
            log.info("GET KARYAWAN");
        }catch (Exception e){
            log.error("GER LIST KARYAWAN ERROR");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }

        return response;
    }

    @Override
    public GenericResponse deleteById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            karyawanRepository.deleteById(id);
            response.setSuccess();
            log.info("DELETE KARYAWAN BY ID {}", id);
        }catch (Exception e){
            log.error("DELETE KARYAWAN ERROR {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        return response;
    }
}
