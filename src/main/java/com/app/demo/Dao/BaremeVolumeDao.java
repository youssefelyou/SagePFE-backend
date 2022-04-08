package com.app.demo.Dao;

import com.app.demo.bean.BaremeVolume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaremeVolumeDao extends JpaRepository<BaremeVolume,Long> {
    BaremeVolume findByBarrageNameAndCote(String name , double cote);
    List<BaremeVolume> deleteByBarrageName(String name);
}
