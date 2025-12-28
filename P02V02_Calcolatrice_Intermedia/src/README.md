# Calcolatrice Intermedia – Java

Questa applicazione rappresenta l’evoluzione della **Calcolatrice Base**, con l’introduzione delle funzioni matematiche avanzate offerte dalla classe `Math`.

Il progetto è pensato a scopo didattico e consolida i concetti fondamentali di Java attraverso un’applicazione console interattiva.

---

## Funzionalità

La calcolatrice consente di eseguire:

- Addizione (`+`)
- Sottrazione (`-`)
- Moltiplicazione (`*`)
- Divisione (`/`) con controllo del divisore
- Modulo (`%`) con controllo del divisore
- Radice quadrata (`r`)
- Potenza (`^`)

Per le operazioni che lo richiedono viene chiesto un secondo operando, mentre le operazioni a singolo operando (radice) utilizzano solo il primo numero.

---

## Concetti applicati

- **Tipi di dato**
  - Uso del tipo `double` per supportare numeri decimali

- **Gestione input**
  - Classe `Scanner`
  - Input numerico e carattere (`char`)

- **Controllo del flusso**
  - Ciclo `do-while` per l’esecuzione ripetuta
  - Condizione di uscita scelta dall’utente

- **Selezione delle operazioni**
  - Istruzione `switch` basata su caratteri

- **Classe Math**
  - `Math.sqrt()` per la radice quadrata
  - `Math.pow()` per la potenza

- **Formattazione output**
  - Uso di `printf` per mostrare risultati con un numero limitato di decimali

---

## Prerequisiti

Conoscenza dei contenuti del repository:

**02-fondamentali-java**

In particolare:
- P01–P05
- Tipi primitivi
- Scanner
- Operatori aritmetici
- Strutture di controllo

---

## Stato del progetto

✔ Funzionante  
✔ Completo  
✔ Pronto per estensioni future  

---

## Sviluppi futuri

- Separazione della logica in metodi
- Introduzione di una struttura OOP
- Gestione più robusta degli input
- Versione avanzata della calcolatrice
