package com.idstartalent.training.dto.karyawan;

import com.idstartalent.training.dto.DetailKaryawanRq;
import lombok.Data;

import java.util.Date;

@Data
public class KaryawanRq {
    private String nama;
    private Date dob;
    private String status;
    private String alamat;
    private DetailKaryawanRq detailKaryawan;
}
