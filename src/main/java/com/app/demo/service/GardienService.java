package com.app.demo.service;


import com.app.demo.bean.Gardien;
import com.app.demo.Dao.GardienDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GardienService {


    @Autowired
    private GardienDao gardienDao;

    public Gardien findByCin(String cin) {
        return gardienDao.findByCin(cin);
    }

    @Transactional
    public int deleteById(long id) {
        return gardienDao.deleteGardiensById(id);
    }

    public List<Gardien> findAll() {
        return gardienDao.findAll();
    }

    public int save (Gardien gardien) {
        if (gardien.getCin() == null){
            return -1;
        }else{
            Gardien gard = findByCin(gardien.getCin());
            if (gard == null){
                gardienDao.save(gardien);
                return 1;
            }else {
                return 0;
            }
        }

    }

}
