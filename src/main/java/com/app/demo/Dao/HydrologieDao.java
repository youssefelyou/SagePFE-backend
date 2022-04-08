package com.app.demo.Dao;

import com.app.demo.bean.Hydrologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HydrologieDao extends JpaRepository<Hydrologie,Long> {
    Hydrologie findByCourEauAndSurface(String courEau , double surface);
    int deleteHydrologiesById(long id);
}
