package com.guernelli.calcoltriceweb1.dto;


public class CalcoloRequest {
    private double a;
    private double b;
    private String operazione;

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public String getOperazione() { return operazione; }
    public void setOperazione(String operazione) { this.operazione = operazione; }
}