package com.example.vSIAF.repository;

import com.example.vSIAF.entity.CtaParEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtaParRepository extends JpaRepository<CtaParEntity, Integer> {
}