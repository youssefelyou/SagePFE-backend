package com.app.demo.Dao;

import com.app.demo.bean.VidangeFond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidangeFondDao extends JpaRepository<VidangeFond,Long> {
    VidangeFond findByCoteSeuilEnterAndDebitMaxEvacue(double coteSeuilEnter,double debitMaxEvacue);
    int deleteVidangeFondsById(long id);
}
