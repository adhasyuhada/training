package com.idstartalent.training.dto.karyawan;

import com.idstartalent.training.dto.DetailKaryawanUpdateRq;
import lombok.Data;

import java.util.Date;

@Data
public class KaryawanUpdateRq {
    private int id;
    private String nama;
    private Date dob;
    private String status;
    private String alamat;
    private DetailKaryawanUpdateRq detailKaryawan;
}
