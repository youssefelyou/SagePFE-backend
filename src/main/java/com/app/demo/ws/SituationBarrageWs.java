package com.app.demo.ws;

import com.app.demo.bean.SituationBarrages;
import com.app.demo.service.SituationBarrageService;
import com.app.demo.ws.vo.SituationBarrageVo;
import com.app.demo.ws.vo.SituationJournaliereVo;
import com.app.demo.ws.vo.SituationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("situationBarrage/situationBarrage")
@CrossOrigin("http://localhost:4200")

public class SituationBarrageWs {


    @GetMapping("/date/{date}")
    public List<SituationBarrages> findByDate(@PathVariable String date) {
        return situationBarrageService.findByDate(date);
    }

    @GetMapping("/dateDebit/{dateDebit}/dateFin/{dateFin}")
    public Map<LocalDateTime, List<SituationBarrageVo>> findByDateBetween(@PathVariable String dateDebit, @PathVariable String dateFin) {
        return situationBarrageService.findByDateBetween(dateDebit, dateFin);
    }

    @GetMapping("/barrageName/{barrageName}")
    public List<SituationBarrages> findByBarrageName(@PathVariable("barrageName") String name) {
        return situationBarrageService.findByBarrageName(name);
    }

    @GetMapping("/situations-barrages/date/{date}")
    public Map<String, SituationBarrages> findSituationBarrages(@PathVariable String date){
        return this.situationBarrageService.findSituationBarrages(date);
    }

    @DeleteMapping("/barrageName/{barrageName}")
    public int deleteByBarrageName(@PathVariable("barrageName") String name) {
        return situationBarrageService.deleteByBarrageName(name);
    }

    @GetMapping("/dateSituation/{dateSituation}/nameBarrage/{nameBarrage}")
    public SituationBarrages findByDateAndBarrageName(@PathVariable("dateSituation")  String date, @PathVariable("nameBarrage") String name) throws ParseException {
        return situationBarrageService.findByDateAndBarrageName(date, name);
    }

    @GetMapping("/dateDebit/{dateDebit}/dateFin/{dateFin}/name/{name}")
    public List<SituationBarrages> findByDateBetweenAndBarrageName(@PathVariable String dateDebit,@PathVariable String dateFin,@PathVariable String name) {
        return situationBarrageService.findByDateBetweenAndBarrageName(dateDebit, dateFin, name);
    }

    @PostMapping("/")
    public int save(@RequestBody SituationBarrages s) {
        System.out.println(s.getBarrage());
        return situationBarrageService.save(s);
    }

    @GetMapping("/")
    public List<SituationBarrages> findAll() {
        return situationBarrageService.findAll();
    }

    @GetMapping("/dateDebut/{dateDebut}/dateFin/{dateFin}")
    public Map<LocalDateTime, List<SituationVo>> findPluie(@PathVariable String dateDebut, @PathVariable String dateFin){
         return this.situationBarrageService.findPluie(dateDebut, dateFin);
    }

    @GetMapping("/situation-Journaliere/date/{date}/yesterday/{yesterday}")
    public List<SituationJournaliereVo> situationJournaliereVos(@PathVariable String date, @PathVariable String yesterday){
        return this.situationBarrageService.situationDonnee(date , yesterday);
    }

    @Autowired
    private SituationBarrageService situationBarrageService;
}
