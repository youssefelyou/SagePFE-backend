package com.app.demo.Dao;

import com.app.demo.bean.Barrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarrageDao extends JpaRepository<Barrage,Long> {
    Barrage findByProvince(String province);
    Barrage findBySousBassin(String sousBassin);
    Barrage findByName(String name);
    int deleteByName(String name);
}
