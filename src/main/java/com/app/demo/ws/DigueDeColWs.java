package com.app.demo.ws;

import com.app.demo.bean.DigueDeCol;
import com.app.demo.service.DigueDeColService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("digue de col/ digue de col")
@CrossOrigin("http://localhost:4200")

public class DigueDeColWs {

    @PostMapping("/")
    public int save(@RequestBody DigueDeCol digueDeCol) {
        System.out.println(digueDeCol.getLongueurCrete());
        return digueDeColService.save(digueDeCol);
    }

    @GetMapping("/")
    public List<DigueDeCol> findAll() {
        return digueDeColService.findAll();
    }

    @Autowired
    private DigueDeColService digueDeColService;
}
