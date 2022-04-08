package com.app.demo.ws;

import com.app.demo.bean.BaremeVolume;
import com.app.demo.service.BaremeVolumeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("baremevolume/baremevolume")
@CrossOrigin("http://localhost:4200")
public class BaremeVolumeWs {
    @GetMapping("/name/{name}/cote/{cote}")
    public BaremeVolume findByBarrageNameAndCote(@PathVariable String name, @PathVariable double cote) {
        return baremeVolumeService.findByBarrageNameAndCote(name, cote);
    }


    @DeleteMapping("/name/{name}")
    public List<BaremeVolume> deleteByBarrageName(@PathVariable String name) {
        return baremeVolumeService.deleteByBarrageName(name);
    }

    @GetMapping("/")
    public List<BaremeVolume> findAll() {
        return baremeVolumeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody BaremeVolume baremeVolume) {
        return baremeVolumeService.save(baremeVolume);
    }

    @Autowired
    private BaremeVolumeService baremeVolumeService;
}
