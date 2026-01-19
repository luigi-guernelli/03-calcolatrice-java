package com.guernelli.calcoltriceweb1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guernelli.calcoltriceweb1.service.CalcolatriceService;
import com.guernelli.calcoltriceweb1.dto.CalcoloRequest;
import com.guernelli.calcoltriceweb1.dto.CalcoloResponse;

@RestController
@RequestMapping("api/calcolatrice")
@CrossOrigin(origins = "http://localhost:4200")
public class CalcolatriceController {
	
    private final CalcolatriceService service;

    public CalcolatriceController(CalcolatriceService service) {
        this.service = service;
    }

    @PostMapping("/calcola")
    public CalcoloResponse calcola(@RequestBody CalcoloRequest request) {
        try {
            double risultato = service.calcola(
                request.getA(),
                request.getB(),
                request.getOperazione()
            );
            return new CalcoloResponse(risultato);
        } catch (IllegalArgumentException e) {
            return new CalcoloResponse(e.getMessage());
        }
    }

}
