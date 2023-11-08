package com.idstartalent.training.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
public class Rekening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;
    private String nama;
    private String jenis;
    private Long rekening;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_karyawan", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Karyawan idKaryawan;

    /*@OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id", nullable = false)
    private Karyawan karyawan;*/

}
