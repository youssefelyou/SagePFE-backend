package com.app.demo.ws;

import com.app.demo.bean.Hydrologie;
import com.app.demo.service.HydrologieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hydrologie/hydrologie")
@CrossOrigin("http://localhost:4200")

public class HydrologieWs {

    @PostMapping("/")
    public int save(@RequestBody Hydrologie hydrologie) {
        return hydrologieService.save(hydrologie);
    }

    @GetMapping("/")
    public List<Hydrologie> findAll() {
        return hydrologieService.findAll();
    }


    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable long id) {
        return hydrologieService.deleteById(id);
    }

    @Autowired
    private HydrologieService hydrologieService;
}
