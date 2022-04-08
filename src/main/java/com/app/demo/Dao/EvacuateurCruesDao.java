package com.app.demo.Dao;

import com.app.demo.bean.EvacuateurCrues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvacuateurCruesDao extends JpaRepository<EvacuateurCrues,Long> {
    EvacuateurCrues findByDebitMaxAndHauteurSeuil(double debitMax , double hateurSeuil);
    int deleteEvacuateurCruesById(long id);
}
