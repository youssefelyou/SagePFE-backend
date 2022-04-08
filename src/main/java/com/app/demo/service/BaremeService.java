package com.app.demo.service;

import com.app.demo.Dao.BaremeDao;
import com.app.demo.bean.Bareme;
import com.app.demo.bean.BaremeDebit;
import com.app.demo.ws.vo.BaremeVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BaremeService {

    @JsonFormat(pattern = "YYYY-MM-dd")
    public Date myDate;
    public List<Bareme> findByDateTime(String dateTime) throws ParseException {
        this.myDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
        long timeInMilliSeconds = myDate.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        return baremeDao.findByDateTime(date1);
    }

    public List<Bareme> findByNom(String nom) {
        return baremeDao.findByNom(nom);
    }

    public  List<Bareme> findByDateTimeAndNom(String dateTime, String nom) throws ParseException {
        this.myDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
        long timeInMilliSeconds = myDate.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        System.out.println(date1);
        System.out.println(nom);
        List<Bareme> myList = baremeDao.findByDateTimeAndNomOrderByHauteur(date1, nom);
        System.out.println(myList.size());
        return  myList;
    }

    public List<java.sql.Date> findBareme(String nomStation) {
        return baremeDao.findBareme(nomStation);
    }

    public int save(Bareme bareme) {
        baremeDao.save(bareme);
        return 1;
    }

    public List<Bareme> findAll() {
        return baremeDao.findAll();
    }

    @Autowired
    private BaremeDao baremeDao;
}
