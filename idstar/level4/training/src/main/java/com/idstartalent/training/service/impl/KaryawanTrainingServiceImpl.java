package com.idstartalent.training.service.impl;

import com.idstartalent.training.dto.karyawantraining.KaryawanTrainingRq;
import com.idstartalent.training.dto.karyawantraining.KaryawanTrainingUpdateRq;
import com.idstartalent.training.dto.rekening.RekeningKaryawanRs;
import com.idstartalent.training.dto.rekening.RekeningRq;
import com.idstartalent.training.dto.rekening.RekeningRs;
import com.idstartalent.training.dto.rekening.RekeningUpdateRq;
import com.idstartalent.training.model.*;
import com.idstartalent.training.repository.KaryawanRepository;
import com.idstartalent.training.repository.KaryawanTrainingRepository;
import com.idstartalent.training.repository.RekeningRepository;
import com.idstartalent.training.repository.TrainingRepository;
import com.idstartalent.training.service.KaryawanService;
import com.idstartalent.training.service.KaryawanTrainingService;
import com.idstartalent.training.service.RekeningService;
import com.idstartalent.training.util.Code;
import com.idstartalent.training.util.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
@Slf4j
public class KaryawanTrainingServiceImpl implements KaryawanTrainingService {

    @Autowired
    KaryawanTrainingRepository karyawanTrainingRepository;

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @Override
    public GenericResponse getListKaryawanTraining() {
        GenericResponse response = new GenericResponse();

        try {
            //get all karyawan training
            List<KaryawanTraining> karyawanTrainings = karyawanTrainingRepository.findAll();

            response.setSuccess(karyawanTrainings);
            log.info("SUCCESS GET LIST KARYAWAN TRAINING");
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR GET LIST KARYAWAN TRAINING {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            log.error("SYSTEM ERROR GET LIST KARYAWAN TRAINING {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @Override
    public GenericResponse saveKaryawanTraining(KaryawanTrainingRq karyawanTrainingRq) {
        GenericResponse response = new GenericResponse();

        try {

            Optional<Karyawan> karyawan = karyawanRepository.findById(karyawanTrainingRq.getKaryawan().getId());
            Optional<Training> training = trainingRepository.findById(karyawanTrainingRq.getTraining().getId());
            KaryawanTraining karyawanTraining = new KaryawanTraining();
            karyawanTraining.setCreatedDate(new Date());
            karyawanTraining.setTanggal(karyawanTraining.getTanggal());
            karyawanTraining.setIdKaryawan(karyawan.orElseThrow());
            karyawanTraining.setIdTraining(training.orElseThrow());

            karyawanTrainingRepository.save(karyawanTraining);

            response.setSuccess(karyawanTraining);
            log.info("SAVE KARYAWAN TRAINING SUCCESS");
        } catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR SAVE KARYAWAN TRAINING {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            log.error("SYSTEM ERROR SAVE KARYAWAN TRAINING  {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse updateKaryawanTraining(KaryawanTrainingUpdateRq karyawanTrainingUpdateRq) {
        GenericResponse response = new GenericResponse();

        try {

            Optional<KaryawanTraining> karyawanTraining = karyawanTrainingRepository.findById(karyawanTrainingUpdateRq.getId());
            Optional<Training> training = trainingRepository.findById(karyawanTrainingUpdateRq.getTraining().getId());
            Optional<Karyawan> karyawan = karyawanRepository.findById(karyawanTrainingUpdateRq.getKaryawan().getId());

            if(karyawanTraining.isPresent() && training.isPresent() && karyawan.isPresent()){
                karyawanTraining.get().setTanggal(karyawanTrainingUpdateRq.getTanggal());
                karyawanTraining.get().setUpdatedDate(new Date());
                karyawanTraining.get().setIdKaryawan(karyawan.orElseThrow());
                karyawanTraining.get().setIdTraining(training.orElseThrow());

                karyawanTrainingRepository.save(karyawanTraining.orElseThrow());
            }else {
                throw new NoSuchElementException();
            }

            response.setSuccess(karyawanTraining);

            log.info("SUCCESS UPDATE KARYAWAN TRAINING");
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR UPDATE KARYAWAN TRAINING");
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("SYSTEM ERROR UPDATE KARYAWAN TRAINING");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse findById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            Optional<KaryawanTraining> karyawanTraining = karyawanTrainingRepository.findById(id);

            response.setSuccess(karyawanTraining.orElseThrow());

            log.info("GET KARYAWAN TRAINING BY ID {}", id);
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR GET KARYAWAN TRAINING BY ID {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("ERROR GET KARYAWAN TRAINING BY ID {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse deleteById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            karyawanTrainingRepository.deleteById(id);
            response.setSuccess();
            log.info("SUCCESS DELETE KARYAWAN TRAINING  BY ID {}", id);
        }catch (Exception e){
            log.error("ERROR DELETE KARYAWAN TRAINING   {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
