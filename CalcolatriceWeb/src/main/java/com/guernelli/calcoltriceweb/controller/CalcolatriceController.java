package com.guernelli.calcoltriceweb.controller;

import com.guernelli.calcoltriceweb.dto.CalcolatriceResponse;
import com.guernelli.calcoltriceweb.service.CalcolatriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calcolatrice")
@CrossOrigin(origins = "*")
public class CalcolatriceController {

    private final CalcolatriceService service;

    public CalcolatriceController(CalcolatriceService service) {
        this.service = service;
    }

    @GetMapping("/calcola")
    public CalcolatriceResponse calcola(
            @RequestParam double a,
            @RequestParam(required = false) Double b,
            @RequestParam String operazione
    ) {
        try {
            double risultato = service.calcola(a, b != null ? b : 0, operazione);
            return new CalcolatriceResponse(risultato);
        } catch (IllegalArgumentException e) {
            return new CalcolatriceResponse(e.getMessage());
        }
    }
}

// somma: test-browser: http://localhost:8080/api/calcolatrice/calcola?a=10&b=5&operazione=add
// errore: test-browser(1): http://localhost:8080/api/calcolatrice/calcola?a=10&b=0&operazione=div
