package com.idstartalent.training.dto.rekening;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@JsonPropertyOrder({"id","created_date", "updated_date","deleted_date","nama","jenis", "rekening"})
@Accessors(chain = true)
public class RekeningRs {
    private int id;
    @JsonProperty("created_date")
    private Date createdDate;
    @JsonProperty("updated_date")
    private Date updatedDate;
    @JsonProperty("deleted_date")
    private Date deletedDate;
    private String nama;
    private String jenis;
    private Long rekening;
    private RekeningKaryawanRs karyawan;
}
