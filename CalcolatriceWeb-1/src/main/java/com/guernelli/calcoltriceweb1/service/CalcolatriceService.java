package com.guernelli.calcoltriceweb1.service;

import org.springframework.stereotype.Service;

@Service
public class CalcolatriceService {

    public double calcola(double a, double b, String op) {

        return switch (op) {
            case "add" -> a + b;
            case "sub" -> a - b;
            case "mul" -> a * b;
            case "div" -> {
                if (b == 0) throw new IllegalArgumentException("Divisione per zero");
                yield a / b;
            }
            case "percent" -> b / 100;
            default -> throw new IllegalArgumentException("Operazione non valida");
        };
    }
}