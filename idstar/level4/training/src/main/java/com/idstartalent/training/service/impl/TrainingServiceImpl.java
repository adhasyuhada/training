package com.idstartalent.training.service.impl;

import com.idstartalent.training.dto.rekening.RekeningKaryawanRs;
import com.idstartalent.training.dto.rekening.RekeningRs;
import com.idstartalent.training.dto.training.TrainingRq;
import com.idstartalent.training.dto.training.TrainingUpdateRq;
import com.idstartalent.training.model.GenericResponse;
import com.idstartalent.training.model.Karyawan;
import com.idstartalent.training.model.Rekening;
import com.idstartalent.training.model.Training;
import com.idstartalent.training.repository.TrainingRepository;
import com.idstartalent.training.service.TrainingService;
import com.idstartalent.training.util.Code;
import com.idstartalent.training.util.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public GenericResponse getListTraining() {
        GenericResponse response = new GenericResponse();
        try {
            List<Training> trainings = trainingRepository.findAll();
            response.setSuccess(trainings);
            log.info("GET LIST TRAINING");
        }catch (Exception e){
            log.error("GER LIST TRAINING ERROR");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse saveTraining(TrainingRq trainingRq) {
        GenericResponse response = new GenericResponse();

        try {


           Training training = new Training();
           training.setCreatedDate(new Date());
           training.setTema(trainingRq.getTema());
           training.setPengajar(trainingRq.getPengajar());

           trainingRepository.save(training);

           response.setSuccess(training);
           log.info("SUCCESS SAVE TRAINING");
        } catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR SAVE TRAINING {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            log.error("SYSTEM ERROR SAVE TRAINING {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse updateTraining(TrainingUpdateRq trainingUpdateRq) {
        GenericResponse response = new GenericResponse();

        try {

            Optional<Training> training = trainingRepository.findById(trainingUpdateRq.getId());

            if(training.isPresent()){
                training.get().setTema(trainingUpdateRq.getTema());
                training.get().setPengajar(trainingUpdateRq.getPengajar());
                training.get().setUpdatedDate(new Date());

                trainingRepository.save(training.get());
            }else {
                throw new NoSuchElementException();
            }

            response.setSuccess(training);

            log.info("SUCCESS UPDATE TRAINING");
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR UPDATE TRAINING");
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("SYSTEM ERROR UPDATE TRAINING");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse findById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            Optional<Training> training = trainingRepository.findById(id);

            response.setSuccess(training.orElseThrow());
            log.info("GET TRAINING BY ID {}", id);
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR GET TRAINING BY ID {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("SYSTEM ERROR GET TRAINING BY ID {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse deleteById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            trainingRepository.deleteById(id);
            response.setSuccess();
            log.info("DELETE TRAINING BY ID {}", id);
        }catch (Exception e){
            log.error("SYSTEM ERROR DELETE TRAINING  {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
