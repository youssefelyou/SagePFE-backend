package com.app.demo.ws;


import com.app.demo.bean.SituationPluviometrique;
import com.app.demo.service.SituationPluviometriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sitpluv/sitpluv")
@CrossOrigin("http://localhost:4200")

public class SituationPluviometriqueProvided {

    @GetMapping("/")
    public List<SituationPluviometrique> findAll() {
        return situationPluviometriqueService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody SituationPluviometrique s) {
        System.out.println(s);
        return situationPluviometriqueService.save(s);
    }


    @DeleteMapping("/nomStation/{nomStation}")
    public int deleteByStationHydrologieNomStation(@PathVariable String nomStation) {
        return situationPluviometriqueService.deleteByStationHydrologieNomStation(nomStation);
    }

    @GetMapping("/nomStation/{nomStation}")
    public List<SituationPluviometrique> findByStationHydrologieNomStation(@PathVariable String nomStation) {
        return situationPluviometriqueService.findByStationHydrologieNomStation(nomStation);
    }
    @GetMapping("/dateDebit/{dateDebit}/dateFin/{dateFin}")
    public List<SituationPluviometrique> findByDateBetween(@PathVariable String dateDebit,@PathVariable String dateFin) {
        return situationPluviometriqueService.findByDateBetween(dateDebit, dateFin);
    }

    @GetMapping("/date/{date}")
    public List<SituationPluviometrique> findByDate(@PathVariable String date) {
        return situationPluviometriqueService.findByDate(date);
    }

    @GetMapping("/date/{date}/nomStation/{nomStation}")
    public SituationPluviometrique findByDateAndStationNomStation(@PathVariable String date,@PathVariable String nomStation) {
        return situationPluviometriqueService.findByDateAndStationNomStation(date, nomStation);
    }

    @Autowired
    private SituationPluviometriqueService situationPluviometriqueService;
}