package com.idstartalent.training.service;

import com.idstartalent.training.dto.karyawan.KaryawanRq;
import com.idstartalent.training.dto.karyawan.KaryawanUpdateRq;
import com.idstartalent.training.dto.training.TrainingRq;
import com.idstartalent.training.dto.training.TrainingUpdateRq;
import com.idstartalent.training.model.GenericResponse;

public interface TrainingService {
    GenericResponse getListTraining();
    GenericResponse saveTraining(TrainingRq trainingRq);
    GenericResponse updateTraining(TrainingUpdateRq trainingUpdateRq);

    GenericResponse findById(int id);
    GenericResponse deleteById(int id);
}
