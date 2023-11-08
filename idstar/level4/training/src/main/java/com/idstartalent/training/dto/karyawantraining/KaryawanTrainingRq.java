package com.idstartalent.training.dto.karyawantraining;


import lombok.Data;

import java.util.Date;

@Data
public class KaryawanTrainingRq {
    private Karyawan karyawan;
    private Training training;
    private Date tanggal;
}
