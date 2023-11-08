package com.idstartalent.training.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;
    private String pengajar;
    private String tema;
}
