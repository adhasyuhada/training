package com.idstartalent.training.dto.rekening;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RekeningKaryawanRs {
    private int id;
    private String nama;
}
