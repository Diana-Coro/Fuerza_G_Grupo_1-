package com.example.vSIAF.repository;

import com.example.vSIAF.entity.EntidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadRepository extends JpaRepository<EntidadEntity, Long> {
}
