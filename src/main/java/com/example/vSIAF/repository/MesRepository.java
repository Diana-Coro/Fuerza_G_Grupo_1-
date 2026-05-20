package com.example.vSIAF.repository;

import com.example.vSIAF.entity.MesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesRepository extends JpaRepository<MesEntity, Integer> {
}