package com.app.demo.ws;

import com.app.demo.bean.Barrage;
import com.app.demo.service.BarrageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("barrage/barrage")
@CrossOrigin("http://localhost:4200")
public class BarrageWs {

    @GetMapping("/province/{province}")
    public Barrage findByProvince(@PathVariable String province) {
        return barrageService.findByProvince(province);
    }

    @GetMapping("/sousBassin/{sousBassin}")
    public Barrage findBySousBassin(@PathVariable String sousBassin) {
        return barrageService.findBySousBassin(sousBassin);
    }

    @GetMapping("/")
    public List<Barrage> findAll() {
        return barrageService.findAll();
    }

    @GetMapping("/name/{name}")
    public Barrage findByName(@PathVariable String name) {
        return barrageService.findByName(name);
    }

    @PostMapping("/")
    public int save(@RequestBody Barrage barrage) {
        return barrageService.save(barrage);
    }

    @DeleteMapping("/name/{name}")
    public int deleteByName(@PathVariable String name) {
        return barrageService.deleteByName(name);
    }

    @Autowired
private BarrageService barrageService;
}
