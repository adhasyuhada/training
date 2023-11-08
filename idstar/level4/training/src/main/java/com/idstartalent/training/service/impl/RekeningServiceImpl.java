package com.idstartalent.training.service.impl;

import com.idstartalent.training.dto.rekening.RekeningKaryawanRs;
import com.idstartalent.training.dto.rekening.RekeningRq;
import com.idstartalent.training.dto.rekening.RekeningRs;
import com.idstartalent.training.dto.rekening.RekeningUpdateRq;
import com.idstartalent.training.model.GenericResponse;
import com.idstartalent.training.model.Karyawan;
import com.idstartalent.training.model.Rekening;
import com.idstartalent.training.repository.KaryawanRepository;
import com.idstartalent.training.repository.RekeningRepository;
import com.idstartalent.training.service.RekeningService;
import com.idstartalent.training.util.Code;
import com.idstartalent.training.util.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class RekeningServiceImpl implements RekeningService {

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    KaryawanRepository karyawanRepository;

    @Override
    public GenericResponse getListRekening() {
        GenericResponse response = new GenericResponse();

        try {
            //get all rekening
            List<Rekening> rekeningList = rekeningRepository.findAll();

            //set response
            List<RekeningRs> listResponse = new ArrayList<>();
            for(Rekening rek : rekeningList){
                RekeningKaryawanRs rekeningKaryawanRs = new RekeningKaryawanRs()
                        .setId(rek.getIdKaryawan().getId())
                        .setNama(rek.getIdKaryawan().getNama());

                RekeningRs res = new RekeningRs()
                        .setId(rek.getId())
                        .setCreatedDate(rek.getCreatedDate())
                        .setUpdatedDate(rek.getUpdatedDate())
                        .setDeletedDate(rek.getDeletedDate())
                        .setNama(rek.getNama())
                        .setJenis(rek.getJenis())
                        .setRekening(rek.getRekening())
                        .setKaryawan(rekeningKaryawanRs);
                listResponse.add(res);
            }

            response.setSuccess(listResponse);
            log.info("GET LIST REKENING");
        }catch (Exception e){
            log.error("GET LIST KARYAWAN ERROR");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @Override
    public GenericResponse saveRekening(RekeningRq rekeningRq) {
        GenericResponse response = new GenericResponse();

        try {

            Rekening rekening = new Rekening();
            rekening.setNama(rekeningRq.getNama());
            rekening.setRekening(rekeningRq.getRekening());
            rekening.setJenis(rekeningRq.getJenis());
            rekening.setNama(rekeningRq.getNama());
            rekening.setCreatedDate(new Date());

            Optional<Karyawan> karyawan = karyawanRepository.findById(rekeningRq.getKaryawan().getId());

            rekening.setIdKaryawan(karyawan.orElseThrow());

            rekeningRepository.save(rekening);

            //set response
            RekeningKaryawanRs rekeningKaryawanRs = new RekeningKaryawanRs()
                    .setId(rekening.getIdKaryawan().getId())
                    .setNama(rekening.getIdKaryawan().getNama());

            RekeningRs res = new RekeningRs()
                    .setId(rekening.getId())
                    .setCreatedDate(rekening.getCreatedDate())
                    .setUpdatedDate(rekening.getUpdatedDate())
                    .setDeletedDate(rekening.getDeletedDate())
                    .setNama(rekening.getNama())
                    .setJenis(rekening.getJenis())
                    .setRekening(rekening.getRekening())
                    .setKaryawan(rekeningKaryawanRs);
            response.setSuccess(res);
            log.info("SAVE REKENING SUCCESS");
        } catch (NoSuchElementException nse){
            log.error("SAVE REKENING BUSINESS ERROR {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            log.error("SAVE REKENING SYSTEM ERROR {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse updateRekening(RekeningUpdateRq rekeningUpdateRq) {
        GenericResponse response = new GenericResponse();

        try {

            Optional<Rekening> rekening = rekeningRepository.findById(rekeningUpdateRq.getId());

            if(rekening.isPresent()){
                rekening.get().setNama(rekeningUpdateRq.getNama());
                rekening.get().setJenis(rekeningUpdateRq.getJenis());
                rekening.get().setRekening(rekeningUpdateRq.getRekening());
                rekening.get().setUpdatedDate(new Date());
                rekening.get().setIdKaryawan(rekening.get().getIdKaryawan());
                rekeningRepository.save(rekening.get());
            }else {
                throw new NoSuchElementException();
            }

            //set response
            RekeningKaryawanRs rekeningKaryawanRs = new RekeningKaryawanRs()
                    .setId(rekening.get().getIdKaryawan().getId())
                    .setNama(rekening.get().getIdKaryawan().getNama());

            RekeningRs res = new RekeningRs()
                    .setId(rekening.get().getId())
                    .setCreatedDate(rekening.get().getCreatedDate())
                    .setUpdatedDate(rekening.get().getUpdatedDate())
                    .setDeletedDate(rekening.get().getDeletedDate())
                    .setNama(rekening.get().getNama())
                    .setJenis(rekening.get().getJenis())
                    .setRekening(rekening.get().getRekening())
                    .setKaryawan(rekeningKaryawanRs);
            response.setSuccess(res);

            log.info("UPDATE REKENING SUCCESS");
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR UPDATE REKENING");
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("ERROR UPDATE REKENING");
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse findById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            Optional<Rekening> rekening = rekeningRepository.findById(id);

            //set response
            RekeningKaryawanRs rekeningKaryawanRs = new RekeningKaryawanRs()
                    .setId(rekening.orElseThrow().getIdKaryawan().getId())
                    .setNama(rekening.get().getIdKaryawan().getNama());

            RekeningRs res = new RekeningRs()
                    .setId(rekening.orElseThrow().getId())
                    .setCreatedDate(rekening.get().getCreatedDate())
                    .setUpdatedDate(rekening.get().getUpdatedDate())
                    .setDeletedDate(rekening.get().getDeletedDate())
                    .setNama(rekening.get().getNama())
                    .setJenis(rekening.get().getJenis())
                    .setRekening(rekening.get().getRekening())
                    .setKaryawan(rekeningKaryawanRs);

            response.setSuccess(res);
            log.info("GET REKENING BY ID {}", id);
        }catch (NoSuchElementException nse){
            log.error("BUSINESS ERROR GET REKENING BY ID {}", nse.getMessage());
            response.setFailed(Code.BUSINESS_ERROR.getCode(), Status.BUSINESS_ERROR, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("ERROR GET REKENING BY ID {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public GenericResponse deleteById(int id) {
        GenericResponse response = new GenericResponse();
        try {
            rekeningRepository.deleteById(id);
            response.setSuccess();
            log.info("DELETE REKENING BY ID {}", id);
        }catch (Exception e){
            log.error("ERROR DELETE REKENING  {}", e.getMessage());
            response.setFailed(Code.SYSTEM_ERROR.getCode(), Status.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
