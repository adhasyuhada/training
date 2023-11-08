package com.idstartalent.training.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "detail_karyawan")
public class DetailKaryawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;
    private int nik;
    private int npwp;

    /*@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_karyawan")*/
    /*@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id", nullable = false)
    private Karyawan karyawan;*/
}

