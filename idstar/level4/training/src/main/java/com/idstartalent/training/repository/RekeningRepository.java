package com.idstartalent.training.repository;

import com.idstartalent.training.model.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Integer> {
}
