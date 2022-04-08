package com.app.demo.Dao;

import com.app.demo.bean.StationClimatologique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationClimatologiqueDao extends JpaRepository<StationClimatologique,Long> {
    StationClimatologique findByName(String name);
    int deleteByName(String name);

    StationClimatologique findById(long id);
    int deleteById(long id);

}