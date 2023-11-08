package com.idstartalent.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;
    private String alamat;
    private Date dob;
    private String nama;
    private String status;

/*    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_karyawan", nullable = false)*/
    /*@OneToOne(mappedBy = "karyawan", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)*/
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "detail_karyawan", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DetailKaryawan detailKaryawan;
}
