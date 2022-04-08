package com.app.demo.ws;

import com.app.demo.bean.StationClimatologique;
import com.app.demo.service.StationClimatologiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("climat/climat")
@CrossOrigin("http://localhost:4200")

public class StationClimatologiqueProvided {

    @GetMapping("/name/{name}")
    public StationClimatologique findByName(@PathVariable String name) {
        return stationClimatologiqueService.findByName(name);
    }

    @DeleteMapping("/name/{name}")
    public int deleteByName(@PathVariable String name) {
        return stationClimatologiqueService.deleteByName(name);
    }

    @GetMapping("/")
    public List<StationClimatologique> findAll() {
        return stationClimatologiqueService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody StationClimatologique stationClimatologique) {
        return stationClimatologiqueService.save(stationClimatologique);
    }

    @Autowired
    private StationClimatologiqueService stationClimatologiqueService;

}