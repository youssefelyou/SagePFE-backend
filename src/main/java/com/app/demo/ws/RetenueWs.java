package com.app.demo.ws;

import com.app.demo.bean.Retenue;
import com.app.demo.service.RetenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("retenue/retenue")
@CrossOrigin("http://localhost:4200")

public class RetenueWs {

    @PostMapping("/")
    public int save(@RequestBody Retenue retenue) {
        return retenueService.save(retenue);
    }


    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable long id) {
        return retenueService.deleteById(id);
    }


    @GetMapping("/")
    public List<Retenue> findAll() {
        return retenueService.findAll();
    }

    @Autowired
    private RetenueService retenueService;
}
