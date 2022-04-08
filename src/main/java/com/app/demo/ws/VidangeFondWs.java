package com.app.demo.ws;

import com.app.demo.bean.VidangeFond;
import com.app.demo.service.VidangeFondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vidangeFond/vidangeFond")
@CrossOrigin("http://localhost:4200")
public class VidangeFondWs {

    @PostMapping("/")
    public int save(@RequestBody VidangeFond vidangeFond) {
        return vidangeFondService.save(vidangeFond);
    }

    @GetMapping("/")
    public List<VidangeFond> findAll() {
        return vidangeFondService.findAll();
    }

    @Autowired
    private VidangeFondService vidangeFondService;

}
