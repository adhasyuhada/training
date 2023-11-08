package com.idstartalent.training.service;

import com.idstartalent.training.dto.karyawan.KaryawanRq;
import com.idstartalent.training.dto.karyawan.KaryawanUpdateRq;
import com.idstartalent.training.model.GenericResponse;

public interface KaryawanService {
    GenericResponse getListKaryawan();
    GenericResponse saveKaryawan(KaryawanRq karyawanRq);
    GenericResponse updateKaryawan(KaryawanUpdateRq karyawanUpdateRq);

    GenericResponse findById(int id);
    GenericResponse deleteById(int id);
}
