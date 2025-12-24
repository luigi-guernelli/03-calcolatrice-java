# Calcolatrice Base;
Il progetto **Calcolatrice Base** ha l'obiettivo di consolidare i concetti fondamentali di Java in particolare:

- la gestione dell'input dell'utente tramite 'Scanner';
- il controllo del flusso del programma tramite il ciclo 'do-while';
- la selezione delle operazioni tramite caratteri ('char') e     	istruzione 'switch'.

Il programma consente all'utente di eseguire operazioni aritmetiche di base e di  decidere se continuare o terminare l'esecuzione della calcolatrice.

## Prerequisiti
Conoscenza del repository: **02-fondamentali-java**
**P01-P05**: Main, Tipi, Variabili, Scanner, Operatori Aritmetici

## Struttura del progetto
- Classe Main (CalcolatriceBase.java): avvio del programma volutamente svikuppato in un'uncia classe. 

## 	Concetti applicati
**1️. Tipi di dato** 
	Tipo (double) per mantenere la  coerenza nei calcoli con numeri 	decilmali.
	
**2. Input utente**
- Uso della classe 'Scanner' per leggere numeri e caratteri da tastiera
- Gestione delle scelte tramite caratteri ('char').

**3. Controllo del flusso**
- Utilizzo del ciclo 'do-while' per permettere l'esecuzione ripetuta della calcolatrice.
-Condizione di uscita basata sulla scelta dell'utente ('s' 'S' / 'n' 'N').

**4. Selezione delle operazioni**
- Uso dello switch per gestire le operazioni aritmetiche:
   - Addizione +
   - Sottrazione -
   - Moltiplicazione *
   - Divisione /
   - Modulo %
 
 **5. Controllo degli errori**
 - Verifica della divisione e del modulo per evitare il divisiore uguale a zero.
 

### Implementazioni
Nella versione successiva (**Calcolatrica Intermedia**) si prevede di: 
- Utilizzare le funzioni della classe 'Math'
- Introdurre il simbolo '=' per la restituzione del risultato
- migliorare la gestione dell'uscita dal programma
- separare la logica di calcolo in metodi dedicati

