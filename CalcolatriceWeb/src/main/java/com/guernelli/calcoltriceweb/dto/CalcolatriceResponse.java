package com.guernelli.calcoltriceweb.dto;

public class CalcolatriceResponse {

    private double risultato;
    private String errore;

    public CalcolatriceResponse(double risultato) {
        this.risultato = risultato;
        this.errore = null;
    }

    public CalcolatriceResponse(String errore) {
        this.errore = errore;
    }

    public double getRisultato() {
        return risultato;
    }

    public String getErrore() {
        return errore;
    }
}
