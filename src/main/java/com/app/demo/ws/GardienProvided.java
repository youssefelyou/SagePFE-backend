package com.app.demo.ws;


import com.app.demo.bean.Gardien;
import com.app.demo.service.GardienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gardien/gardien")
@CrossOrigin("http://localhost:4200")

public class GardienProvided {


    @GetMapping("/")
    public List<Gardien> findAll() {
        return gardienService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Gardien gardien) {
        return gardienService.save(gardien);
    }

    @Autowired
    private GardienService gardienService;
}
