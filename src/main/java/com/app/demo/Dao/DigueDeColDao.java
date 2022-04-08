package com.app.demo.Dao;

import com.app.demo.bean.DigueDeCol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigueDeColDao extends JpaRepository<DigueDeCol,Long> {
    DigueDeCol findByHauteurSurFondationAndLargeurCrete(double hauteurSurFondation , double largeurCrete);
    int deleteDigueDeColsById(long id);
}
