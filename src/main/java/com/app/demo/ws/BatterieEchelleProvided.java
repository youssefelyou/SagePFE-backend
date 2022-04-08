package com.app.demo.ws;

import com.app.demo.bean.BatterieEchelle;
import com.app.demo.service.BatterieEchelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "batterie/batterie")
@CrossOrigin("http://localhost:4200")

public class BatterieEchelleProvided {

    @GetMapping("/")
    public List<BatterieEchelle> findAll() {
        return batterieEchelleService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody BatterieEchelle batterieEchelle) {
        return batterieEchelleService.save(batterieEchelle);
    }

    @GetMapping("/nomStation/{nomStation}")
    public List<BatterieEchelle> findByStationNomStation(@PathVariable String nomStation) {
        return batterieEchelleService.findByStationNomStation(nomStation);
    }

    @DeleteMapping("/nomStation/{nomStation}")
    public int deleteByStationNomStation(@PathVariable String nomStation) {
        return batterieEchelleService.deleteByStationNomStation(nomStation);
    }

    @Autowired
    private BatterieEchelleService batterieEchelleService;
}
