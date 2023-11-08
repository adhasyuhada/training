package com.idstartalent.training.service;

import com.idstartalent.training.dto.karyawantraining.KaryawanTrainingRq;
import com.idstartalent.training.dto.karyawantraining.KaryawanTrainingUpdateRq;
import com.idstartalent.training.dto.rekening.RekeningRq;
import com.idstartalent.training.dto.rekening.RekeningUpdateRq;
import com.idstartalent.training.model.GenericResponse;

public interface KaryawanTrainingService {
    GenericResponse getListKaryawanTraining();
    GenericResponse saveKaryawanTraining(KaryawanTrainingRq karyawanTrainingRq);
    GenericResponse updateKaryawanTraining(KaryawanTrainingUpdateRq karyawanTrainingUpdateRq);

    GenericResponse findById(int id);
    GenericResponse deleteById(int id);
}
