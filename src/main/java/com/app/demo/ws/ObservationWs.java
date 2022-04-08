package com.app.demo.ws;

import com.app.demo.bean.Observation;
import com.app.demo.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("observation/observation")
@CrossOrigin("http://localhost:4200")

public class ObservationWs {

    @PostMapping("/")
    public int save(@RequestBody Observation observation) {
        return observationService.save(observation);
    }

    @GetMapping("/")
    public List<Observation> findAll() {
        return observationService.findAll();
    }

    @Autowired
    private ObservationService observationService;

}
