package com.example.vSIAF.repository;

import com.example.vSIAF.entity.ObjetoGasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoGastoRepository extends JpaRepository<ObjetoGasto, Long> {

}