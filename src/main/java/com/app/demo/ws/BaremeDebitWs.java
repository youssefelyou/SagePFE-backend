package com.app.demo.ws;

import com.app.demo.bean.BaremeDebit;
import com.app.demo.service.BaremeDebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("baremeDebit/baremeDebit")
@CrossOrigin("http://localhost:4200")
public class BaremeDebitWs {

    @GetMapping("/nomStation/{nomStation}/hauteur/{hauteur}")
    public BaremeDebit findByStationHydrologieNomStationAndHauteur(@PathVariable String nomStation,@PathVariable double hauteur) {
        return baremeDebitService.findByStationHydrologieNomStationAndHauteur(nomStation, hauteur);
    }

    @DeleteMapping("/nomStation/{nomStation}")
    public List<BaremeDebit> deleteByStationHydrologieNomStation(@PathVariable String nomStation) {
        return baremeDebitService.deleteByStationHydrologieNomStation(nomStation);
    }

    @PostMapping("/")
    public int save(@RequestBody BaremeDebit baremeDebit) {
        return baremeDebitService.save(baremeDebit);
    }


    @GetMapping("/")
    public List<BaremeDebit> findAll() {
        return baremeDebitService.findAll();
    }

    @Autowired
    private BaremeDebitService baremeDebitService;
}
