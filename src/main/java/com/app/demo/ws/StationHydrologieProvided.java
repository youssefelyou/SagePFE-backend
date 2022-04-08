package com.app.demo.ws;

import com.app.demo.bean.StationHydrologie;
import com.app.demo.service.StationHydrologieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("statpluv/statpluv")
@CrossOrigin("http://localhost:4200")

public class StationHydrologieProvided {


    @GetMapping("/dateMiseEnService/{dateMiseEnService}")
    public StationHydrologie findByDateMiseEnService(@PathVariable Date dateMiseEnService) {
        return stationHydrologieService.findByDateMiseEnService(dateMiseEnService);
    }

    @GetMapping("/province/{province}")
    public StationHydrologie findByProvince(@PathVariable String province) {
        return stationHydrologieService.findByProvince(province);
    }

    @GetMapping("/nomStation/{nomStation}")
    public StationHydrologie findByNomStation(@PathVariable String nomStation) {
        return stationHydrologieService.findByNomStation(nomStation);
    }

    @DeleteMapping("/nomStation/{nomStation}")
    public int deleteByNomStaion(@PathVariable String nomStation) {
        return stationHydrologieService.deleteByNomStaion(nomStation);
    }

    @GetMapping("/id/{id}")
    public StationHydrologie findStationHydrologieById(@PathVariable long id) {
        return stationHydrologieService.findStationHydrologieById(id);
    }

    @GetMapping("/")
    public List<StationHydrologie> findAll() {
        return stationHydrologieService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody StationHydrologie stationHydrologie) {
        return stationHydrologieService.save(stationHydrologie);
    }

    @GetMapping("/nrePoste/{nrePoste}")
    public StationHydrologie findByNrePoste(@PathVariable String nrePoste) {
        return stationHydrologieService.findByNrePoste(nrePoste);
    }

    @DeleteMapping("/nrePoste/{nrePoste}")
    public int deleteByNrePoste(@PathVariable String nrePoste) {
        return stationHydrologieService.deleteByNrePoste(nrePoste);
    }

    @GetMapping("/sousbassin/{sousbassin}")
    public StationHydrologie findBySousbassin(@PathVariable String sousbassin) {
        return stationHydrologieService.findBySousbassin(sousbassin);
    }

    @GetMapping("/list/barrage-station")
    public List<String> listLibelle(){
        return this.stationHydrologieService.ListLibelle();
    }

    @Autowired
    private StationHydrologieService stationHydrologieService;
}