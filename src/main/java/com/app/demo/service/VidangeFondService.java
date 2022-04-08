package com.app.demo.service;

import com.app.demo.Dao.VidangeFondDao;
import com.app.demo.bean.Retenue;
import com.app.demo.bean.VidangeFond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VidangeFondService {
    public int save(VidangeFond vidangeFond ) {
        VidangeFond vidangeFond1 = this.findByCoteSeuilEnterAndDebitMaxEvacue(vidangeFond.getCoteSeuilEnter(),vidangeFond.getDebitMaxEvacue());
        if (vidangeFond1 == null){
            vidangeFondDao.save(vidangeFond);
            return 1;
        }else {
            return 0;
        }

    }

    public VidangeFond findByCoteSeuilEnterAndDebitMaxEvacue(double coteSeuilEnter, double debitMaxEvacue) {
        return vidangeFondDao.findByCoteSeuilEnterAndDebitMaxEvacue(coteSeuilEnter, debitMaxEvacue);
    }

    public List<VidangeFond> findAll() {
        return vidangeFondDao.findAll();
    }

    @Transactional
    public int deleteById(long id) {
        return vidangeFondDao.deleteVidangeFondsById(id);
    }
    @Autowired
    private VidangeFondDao vidangeFondDao;
}
