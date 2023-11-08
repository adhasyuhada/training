package com.idstartalent.training.service;

import com.idstartalent.training.dto.rekening.RekeningRq;
import com.idstartalent.training.dto.rekening.RekeningUpdateRq;
import com.idstartalent.training.model.GenericResponse;

public interface RekeningService {
    GenericResponse getListRekening();
    GenericResponse saveRekening(RekeningRq rekeningRq);
    GenericResponse updateRekening(RekeningUpdateRq rekeningUpdateRq);

    GenericResponse findById(int id);
    GenericResponse deleteById(int id);
}
