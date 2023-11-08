package com.idstartalent.training.repository;

import com.idstartalent.training.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Integer> {
}
