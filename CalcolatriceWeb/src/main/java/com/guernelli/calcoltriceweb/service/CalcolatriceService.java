package com.guernelli.calcoltriceweb.service;
import org.springframework.stereotype.Service;

@Service
public class CalcolatriceService {

	public double calcola(double a, double b, String operazione) {

	    return switch (operazione.toLowerCase()) {
	        case "add" -> a + b;
	        case "sub" -> a - b;
	        case "mul" -> a * b;
	        case "div" -> {
	            if (b == 0) throw new IllegalArgumentException("Divisione per zero");
	            yield a / b;
	        }
	        case "mod" -> {
	            if (b == 0) throw new IllegalArgumentException("Modulo per zero");
	            yield a % b;
	        }
	        case "pow" -> Math.pow(a, b);
	        case "sqrt" -> {
	            if (a < 0) throw new IllegalArgumentException("Radice di numero negativo");
	            yield Math.sqrt(a);
	        }
	        default -> throw new IllegalArgumentException("Operazione non valida");
	    };
	}

}
