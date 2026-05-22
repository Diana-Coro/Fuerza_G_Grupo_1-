package com.example.vSIAF.repository;

import com.example.vSIAF.entity.UnidadadminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadadminRepository extends JpaRepository<UnidadadminEntity, Long> {

}