package com.idstartalent.training.repository;

import com.idstartalent.training.model.DetailKaryawan;
import com.idstartalent.training.model.KaryawanTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanTrainingRepository extends JpaRepository<KaryawanTraining, Integer> {
}
