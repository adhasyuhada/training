package com.idstartalent.training.dto.rekening;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RekeningRq {
    private String nama;
    private String jenis;
    private Long rekening;
    private RekeningKaryawanRq karyawan;
}
