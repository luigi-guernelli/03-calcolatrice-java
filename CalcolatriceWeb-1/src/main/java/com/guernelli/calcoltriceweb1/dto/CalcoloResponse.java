package com.guernelli.calcoltriceweb1.dto;

public class CalcoloResponse {
    private double risultato;
    private String errore;

    public CalcoloResponse(double risultato) {
        this.risultato = risultato;
    }

    public CalcoloResponse(String errore) {
        this.errore = errore;
    }

    public double getRisultato() { return risultato; }
    public String getErrore() { return errore; }
}