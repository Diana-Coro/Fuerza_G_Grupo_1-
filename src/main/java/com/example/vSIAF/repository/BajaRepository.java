package com.example.vSIAF.repository;

import com.example.vSIAF.entity.BajaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BajaRepository extends JpaRepository<BajaEntity, Integer> {
}


