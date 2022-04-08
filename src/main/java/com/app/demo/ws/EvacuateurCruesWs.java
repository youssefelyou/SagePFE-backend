package com.app.demo.ws;

import com.app.demo.bean.EvacuateurCrues;
import com.app.demo.service.EvacuateurCruesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("evacuateur/evacuateur")
@CrossOrigin("http://localhost:4200")

public class EvacuateurCruesWs {


    @PostMapping("/")
    public int save(@RequestBody EvacuateurCrues evacuateurCrues) {
        return evacuateurCruesService.save(evacuateurCrues);
    }

    @GetMapping("/")
    public List<EvacuateurCrues> findAll() {
        return evacuateurCruesService.findAll();
    }

    @Autowired
    private EvacuateurCruesService evacuateurCruesService;

}
