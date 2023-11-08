package com.idstartalent.training.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Data
@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;
    private Date tanggal;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_karyawan", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Karyawan idKaryawan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_training", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Training idTraining;
}
