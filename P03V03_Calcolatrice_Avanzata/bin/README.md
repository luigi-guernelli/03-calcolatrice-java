# Calcolatrice Avanzata in Java

Una calcolatrice da riga di comando con comportamento simile alle calcolatrici reali:  
inserisci primo numero → scegli operazione → inserisci secondo numero (se necessario) → premi `=` per vedere il risultato.

Supporta le seguenti operazioni:

<ul>
<li>Simbolo: `+ - * / % ^ `</li>
<li>Operazione: `Addizione; Sottrazione; Moltiplicazione; Divisione; Modulo (resto); Potenza; Radice quadrata.`</li>
</ul>

## Caratteristiche principali

- Richiede espressamente il tasto `=` per eseguire il calcolo
- Controllo degli errori (divisione/modulo per zero, radice di negativo)
- Possibilità di eseguire più calcoli consecutivi
- Utilizzo di `switch`, `Scanner`, `Math.pow()` e `Math.sqrt()`
- Messaggi chiari di errore con `System.err`
