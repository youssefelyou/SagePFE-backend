package com.app.demo.ws;

import com.app.demo.bean.Bareme;
import com.app.demo.service.BaremeService;
import com.app.demo.ws.vo.BaremeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("bareme/bareme")
@CrossOrigin("http://localhost:4200")
public class BaremeWs {

    @GetMapping("/dateTime/{dateTime}")
    public List<Bareme> findByDateTime(@PathVariable String dateTime) throws ParseException {
        return baremeService.findByDateTime(dateTime);
    }
    @GetMapping("/nom/{nom}")
    public List<Bareme> findByNom(@PathVariable String nom) {
        return baremeService.findByNom(nom);
    }

    @GetMapping("/dateTime/{dateTime}/nom/{nom}")
    public  List<Bareme> findByDateTimeAndNom(@PathVariable String dateTime, @PathVariable String nom) throws ParseException {
        return baremeService.findByDateTimeAndNom(dateTime, nom);
    }

    @GetMapping("/lists/{nomStation}")
    public List<Date> findBareme(@PathVariable String nomStation) {
        return baremeService.findBareme(nomStation);
    }

    @PostMapping("/")
    public int save(@RequestBody Bareme bareme) {
        return baremeService.save(bareme);
    }

    @GetMapping("/")
    public List<Bareme> findAll() {
        return baremeService.findAll();
    }

    @Autowired
    private BaremeService baremeService;
}
