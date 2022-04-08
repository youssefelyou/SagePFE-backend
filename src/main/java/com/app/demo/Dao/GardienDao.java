package com.app.demo.Dao;

import com.app.demo.bean.Gardien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardienDao extends JpaRepository<Gardien,Long > {

    Gardien findByCin(String cin);
    int deleteGardiensById(long id);
}
