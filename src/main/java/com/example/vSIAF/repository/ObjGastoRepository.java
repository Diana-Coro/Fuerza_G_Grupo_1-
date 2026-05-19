package com.example.vSIAF.repository;
 
import com.example.vSIAF.entity.ObjGastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ObjGastoRepository extends JpaRepository<ObjGastoEntity, String> {
}