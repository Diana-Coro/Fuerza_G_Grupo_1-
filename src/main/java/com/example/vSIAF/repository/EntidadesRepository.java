package com.example.vSIAF.repository;

import com.example.vSIAF.entity.EntidadesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntidadesRepository extends JpaRepository<EntidadesEntity, Integer> {
}

