package com.app.demo.service;

import com.app.demo.Dao.SituationBarragesDao;
import com.app.demo.Dao.SituationPluviometriqueDao;
import com.app.demo.bean.Barrage;
import com.app.demo.bean.Observation;
import com.app.demo.bean.SituationBarrages;
import com.app.demo.bean.SituationPluviometrique;
import com.app.demo.ws.vo.SituationBarrageVo;
import com.app.demo.ws.vo.SituationJournaliereVo;
import com.app.demo.ws.vo.SituationVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SituationBarrageService {
    @JsonFormat(pattern = "yyyy-MM-dd h:mm:ss")
    public LocalDateTime dat;
    @JsonFormat(pattern = "yyyy-MM-dd h:mm:ss")
    public LocalDateTime date1;

    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }

    public List<SituationBarrages> findByDate(String date) {
        this.dat = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        return situationBarragesDao.findByDate(this.dat);
    }

    public Map<String, SituationBarrages> findSituationBarrages(String date){
        this.dat = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        List<SituationBarrages> situationBarragesList = situationBarragesDao.findByDate(this.dat);
        Map<String, SituationBarrages> barragesMap = new HashMap<>();
        List<Barrage> barrageList = this.barrageService.findAll();
        for (Barrage barrage: barrageList)
        {
            for (SituationBarrages situationBarrages : situationBarragesList) {
                if (barrage.getName().equals(situationBarrages.getBarrage().getName())){
                    barragesMap.put(barrage.getName(),situationBarrages);
                }
            }

        }

        return barragesMap;
    }

    public List<SituationBarrages> findByBarrageName(String name) {
        return situationBarragesDao.findByBarrageName(name);
    }



    public List<SituationBarrages> findByDateBetweenAndBarrageName(String dateDebit, String dateFin, String name) {
        this.dat = LocalDateTime.parse(dateDebit, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        this.date1 = LocalDateTime.parse(dateFin, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));

        return situationBarragesDao.findByDateBetweenAndBarrageName(this.dat, this.date1, name);
    }

    public SituationBarrages findByDateAndBarrageName(String date, String name) {
        this.date1 = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        return situationBarragesDao.findByDateAndBarrageName(date1, name);
    }

    @Transactional
    public int deleteByBarrageName(String name) {
        return situationBarragesDao.deleteByBarrageName(name);
    }

    public int save(SituationBarrages s) {
        Barrage barrage = barrageService.findByName(s.getBarrage().getName());
        Observation observation = observationService.findByAepAndBpAndCmgAndCamAndFuitsAndCr(
                s.getObservation().getAep(),
                s.getObservation().getBp(),
                s.getObservation().getCmg(),s.getObservation().getCam(),
                s.getObservation().getFuits(),s.getObservation().getCr());
        if (barrage != null) {
            s.setBarrage(barrage);
        }
        if (observation == null){
            Observation obs = new Observation();
            this.observationService.save(obs);
            s.setObservation(obs);
        }else{
            s.setObservation(observation);
        }
        situationBarragesDao.save(s);
        return 1;
    }

    public List<SituationBarrages> findAll() {
        return situationBarragesDao.findAll();
    }

    public Map<LocalDateTime, List<SituationBarrageVo>> findByDateBetween(String dateDebit, String dateFin) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a");
        Map<LocalDateTime, List<SituationBarrageVo>> map = new HashMap<LocalDateTime, List<SituationBarrageVo>>();
        LocalDate localDateDebutObj = LocalDate.parse(dateDebit, dateTimeFormatter);
        LocalDate localDatFinObj = LocalDate.parse(dateFin, dateTimeFormatter);
        this.dat = LocalDateTime.parse(dateDebit, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        this.date1 = LocalDateTime.parse(dateFin, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        List<SituationBarrages> st = situationBarragesDao.findByDateBetween(this.dat, this.date1);
        List<SituationBarrageVo> situationBarrageVoList = new ArrayList<>();
        for (SituationBarrages s : st
        ) {
            SituationBarrageVo situationVo = new SituationBarrageVo();
            situationVo.setPluie(s.getPluie());
            situationVo.setBarrage(s.getBarrage().getName());
            situationVo.setBac(s.getBac());
            situationVo.setVolumeActuel(s.getVolumeActuel());
            situationVo.setVolumeNormal(s.getVolumeNormal());
            situationVo.setDebit(s.getDebit());
            situationVo.setTr(s.getTauxRemplissage());
            situationVo.setDate(s.getDate());

            situationBarrageVoList.add(situationVo);
        }
        List<LocalDate> listDate = this.getDatesBetween(localDateDebutObj, localDatFinObj);
        List<SituationBarrageVo> voList = new ArrayList<>();

        for (LocalDate date : listDate) {
            LocalDateTime localDateTime3 = date.atTime(07, 00);
            for (SituationBarrageVo situationVo : situationBarrageVoList
            ) {
                boolean isEqual = situationVo.getDate().isEqual(localDateTime3);
                if (isEqual) {
                    voList.add(situationVo);
                }
            }
            System.out.println("list 3: " + voList.size());

            if (voList.size() != 0) {
                map.put(localDateTime3, this.clone2(voList));
            }
            voList.clear();
        }

        return map;
    }


    public Map<LocalDateTime, List<SituationVo>> findPluie(String dateDebut, String dateFin) {

        Map<LocalDateTime, List<SituationVo>> map = new HashMap<LocalDateTime, List<SituationVo>>();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a");
        LocalDate localDateDebutObj = LocalDate.parse(dateDebut, dateTimeFormatter);
        LocalDate localDatFinObj = LocalDate.parse(dateFin, dateTimeFormatter);
        this.dat = LocalDateTime.parse(dateDebut, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        this.date1 = LocalDateTime.parse(dateFin, DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a"));
        List<SituationBarrages> st = this.situationBarragesDao.findByDateBetween(this.dat, this.date1);
        List<SituationPluviometrique> sp = this.situationPluviometriqueDao.findByDateBetween(this.dat, this.date1);
        List<SituationVo> situationVoList = new ArrayList<>();

        for (SituationBarrages s : st
        ) {
            SituationVo situationVo = new SituationVo();
            situationVo.setPluie(s.getPluie());
            ;
            situationVo.setLibelle(s.getBarrage().getName());
            situationVo.setDate(s.getDate());
            situationVoList.add(situationVo);
        }

        for (SituationPluviometrique s : sp
        ) {
            SituationVo situationVo = new SituationVo();
            situationVo.setPluie(s.getPluie());
            ;
            situationVo.setLibelle(s.getStation().getNomStation());
            situationVo.setDate(s.getDate());
            situationVoList.add(situationVo);
        }

        List<LocalDate> listDate = this.getDatesBetween(localDateDebutObj, localDatFinObj);
//        System.out.println(listDate);
//        for (SituationVo vo: situationVoList
//             ) {
//            System.out.println(vo.getDate() + " + " +  vo.getPluie() + " + " + vo.getLibelle());
//        }


        List<SituationVo> voList = new ArrayList<>();

        for (LocalDate date : listDate) {
            LocalDateTime localDateTime3 = date.atTime(07, 00);
            for (SituationVo situationVo : situationVoList
            ) {
                boolean isEqual = situationVo.getDate().isEqual(localDateTime3);
                if (isEqual) {
                    System.out.println(situationVo.getDate() + " " + situationVo.getPluie() + " " + situationVo.getLibelle());
                    voList.add(situationVo);
                }
            }
            System.out.println("list 3: " + voList.size());

            if (voList.size() != 0) {
                map.put(localDateTime3, this.clone(voList));
            }
            Set<LocalDateTime> setInt = map.keySet();

            voList.clear();

        }
        return map;
    }

    public List<SituationVo> clone(List<SituationVo> situationVos) {
        List<SituationVo> myClone = new ArrayList<>();
        myClone.addAll(situationVos);
        return myClone;
    }
    public List<SituationBarrageVo> clone2(List<SituationBarrageVo> situationVos) {
        List<SituationBarrageVo> myClone = new ArrayList<>();
        myClone.addAll(situationVos);
        return myClone;
    }

    public SituationJournaliereVo cloneSituation(SituationJournaliereVo situationJournaliereVo) {

        SituationJournaliereVo sit = new SituationJournaliereVo();
        sit.setOued(situationJournaliereVo.getOued());
        sit.setProvince(situationJournaliereVo.getProvince());
        sit.setDebitMax(situationJournaliereVo.getDebitMax());
        sit.setPluie(situationJournaliereVo.getPluie());
        sit.setLibelle(situationJournaliereVo.getLibelle());
        sit.setDebit(situationJournaliereVo.getDebit());
        sit.setNeige(situationJournaliereVo.getNeige());
        sit.setAep(situationJournaliereVo.getAep());
        sit.setBac(situationJournaliereVo.getBac());
        sit.setCam(situationJournaliereVo.getCam());
        sit.setBp(situationJournaliereVo.getBp());
        sit.setCmg(situationJournaliereVo.getCmg());
        sit.setCr(situationJournaliereVo.getCr());
        sit.setEvacuateurCrues(situationJournaliereVo.getEvacuateurCrues());
        sit.setFuits(situationJournaliereVo.getFuits());
        sit.setVolumeNormal(situationJournaliereVo.getVolumeNormal());
        sit.setVolumeActuel(situationJournaliereVo.getVolumeActuel());
        sit.setVidangeFond(situationJournaliereVo.getVidangeFond());
        sit.setVarationVolume(situationJournaliereVo.getVarationVolume());
        sit.setTurbinage(situationJournaliereVo.getTurbinage());
        sit.setTurbidite(situationJournaliereVo.getTurbidite());
        sit.setTauxRemplissage(situationJournaliereVo.getTauxRemplissage());
        sit.setIrrigation(situationJournaliereVo.getIrrigation());
        sit.setNiveauEau(situationJournaliereVo.getNiveauEau());
        sit.setHeurDebitMax(situationJournaliereVo.getHeurDebitMax());
        sit.setHauteurmax(situationJournaliereVo.getHauteurmax());
        sit.setDebitPreAlerte(situationJournaliereVo.getDebitPreAlerte());
        sit.setDebitAlerte(situationJournaliereVo.getDebitAlerte());
        sit.setCotePreAlerte(situationJournaliereVo.getCotePreAlerte());
        sit.setCoteAlerte(situationJournaliereVo.getCoteAlerte());
        sit.setOued(situationJournaliereVo.getOued());
        sit.setSousBassin(situationJournaliereVo.getSousBassin());
        sit.setDate(situationJournaliereVo.getDate());
        return sit;
    }

    public List<SituationJournaliereVo> situationDonnee(String dateToday , String yesterday) {
        List<SituationJournaliereVo> situationJournaliereVoList = new ArrayList<>();
        List<SituationBarrages> situationTodayBarragesList = this.findByDate(dateToday);
        List<SituationPluviometrique> situationTodayPluviometriqueList = this.situationPluviometriqueService.findByDate(dateToday);
        List<SituationBarrages> situationYesterdayBarragesList = this.findByDate(yesterday);
        List<SituationPluviometrique> situationYesterdayPluviometriqueList = this.situationPluviometriqueService.findByDate(yesterday);
        SituationJournaliereVo situationJournaliereVo = new SituationJournaliereVo();
        for (SituationBarrages barrage : situationTodayBarragesList) {
            System.out.println(barrage.getDate());
            situationJournaliereVo.setAep(barrage.getObservation().getAep());
            situationJournaliereVo.setBac(barrage.getBac());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm");
            String formattedDateTime = barrage.getDate().format(formatter);
            System.out.println(formattedDateTime);
            situationJournaliereVo.setDate(formattedDateTime);
            situationJournaliereVo.setCam(barrage.getObservation().getCam());
            situationJournaliereVo.setLibelle(barrage.getBarrage().getName());
            situationJournaliereVo.setPluie(barrage.getPluie());
            situationJournaliereVo.setBp(barrage.getObservation().getBp());
            situationJournaliereVo.setDebit(barrage.getDebit());
            situationJournaliereVo.setCmg(barrage.getObservation().getCmg());
            situationJournaliereVo.setCr(barrage.getObservation().getCr());
            situationJournaliereVo.setEvacuateurCrues(barrage.getEvacuateurCrues());
            situationJournaliereVo.setFuits(barrage.getObservation().getFuits());
            situationJournaliereVo.setNiveauEau(barrage.getHauteurActuel());
            situationJournaliereVo.setVolumeNormal(barrage.getVolumeNormal());
            situationJournaliereVo.setVolumeActuel(barrage.getVolumeActuel());
            situationJournaliereVo.setVidangeFond(barrage.getVidangeFond());
            situationJournaliereVo.setTurbinage(barrage.getTurbinage());
            situationJournaliereVo.setTurbidite(barrage.getTurbidite());
            situationJournaliereVo.setTauxRemplissage(barrage.getTauxRemplissage());
            situationJournaliereVo.setNeige(barrage.getNeige());
            situationJournaliereVo.setIrrigation(barrage.getIrrigation());
            situationJournaliereVo.setProvince(barrage.getBarrage().getProvince());
            situationJournaliereVo.setOued(barrage.getBarrage().getOued());
            situationJournaliereVo.setSousBassin(barrage.getBarrage().getSousBassin());

            situationJournaliereVoList.add(this.cloneSituation(situationJournaliereVo));
        }

        situationJournaliereVo = new SituationJournaliereVo();
        for (SituationPluviometrique situationPluviometrique : situationTodayPluviometriqueList)
        {
            System.out.println(situationPluviometrique.getDate());
            situationJournaliereVo.setNiveauEau(situationPluviometrique.getNiveauEau());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm");
            String formattedDateTime = situationPluviometrique.getDate().format(formatter);
            System.out.println(formattedDateTime);
            situationJournaliereVo.setDate(formattedDateTime);
            situationJournaliereVo.setHeurDebitMax(situationPluviometrique.getHeurDebitMax());
            situationJournaliereVo.setHauteurmax(situationPluviometrique.getHauteurmax());
            situationJournaliereVo.setDebitPreAlerte(situationPluviometrique.getDebitPreAlerte());
            situationJournaliereVo.setDebit(situationPluviometrique.getDebit());
            situationJournaliereVo.setDebitAlerte(situationPluviometrique.getDebitAlerte());
            situationJournaliereVo.setCotePreAlerte(situationPluviometrique.getCotePreAlerte());
            situationJournaliereVo.setCoteAlerte(situationPluviometrique.getCoteAlerte());
            situationJournaliereVo.setLibelle(situationPluviometrique.getStation().getNomStation());
            situationJournaliereVo.setPluie(situationPluviometrique.getPluie());
            situationJournaliereVo.setNeige(situationPluviometrique.getNeige());
            situationJournaliereVo.setDebitMax(situationPluviometrique.getDebitMax());
            situationJournaliereVo.setProvince(situationPluviometrique.getStation().getProvince());
            situationJournaliereVo.setOued(situationPluviometrique.getStation().getOued());
            situationJournaliereVo.setSousBassin(situationPluviometrique.getStation().getSousbassin());

            situationJournaliereVoList.add(this.cloneSituation(situationJournaliereVo));
        }
        for (SituationJournaliereVo situationJournaliereVo1 : situationJournaliereVoList
        ) {
            for (SituationBarrages situationBarrages: situationYesterdayBarragesList
                 ) {
                if (situationJournaliereVo1.getLibelle().equals(situationBarrages.getBarrage().getName())){
                    situationJournaliereVo1.setNiveauEauYesterday(situationBarrages.getHauteurActuel());
                    situationJournaliereVo1.setVolumeYesterday(situationBarrages.getVolumeActuel());
                }
            }
            for (SituationPluviometrique situationPluviometrique : situationYesterdayPluviometriqueList){
                if (situationJournaliereVo1.getLibelle().equals(situationPluviometrique.getStation().getNomStation())){
                    situationJournaliereVo1.setNiveauEauYesterday(situationPluviometrique.getNiveauEau());
                }
            }
        }

        for (SituationJournaliereVo situationJournaliereVo1: situationJournaliereVoList
             ) {
            System.out.println(situationJournaliereVo1.getSousBassin());
        }

        return situationJournaliereVoList;
    }

    @Autowired
    private SituationBarragesDao situationBarragesDao;
    @Autowired
    private SituationPluviometriqueService situationPluviometriqueService;
    @Autowired
    private SituationPluviometriqueDao situationPluviometriqueDao;
    @Autowired
    private BarrageService barrageService;
    @Autowired
    private ObservationService observationService;
}
