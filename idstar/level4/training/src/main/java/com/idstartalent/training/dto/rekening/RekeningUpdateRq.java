package com.idstartalent.training.dto.rekening;


import lombok.Data;

@Data
public class RekeningUpdateRq {
    private int id;
    private String nama;
    private String jenis;
    private Long rekening;
    private RekeningKaryawanRq karyawan;
}
