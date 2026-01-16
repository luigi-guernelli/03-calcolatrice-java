import java.util.Scanner;

/**
 * Calcolatrice Avanzata
 *
 * Calcolatrice console che utilizza uno stato interno e il comando '='
 * per eseguire il calcolo finale, simulando il comportamento di una
 * calcolatrice reale.
 * Concetti utilizzati
 *   Scanner per input utente
 *   Variabili di stato
 *   Switch annidati
 *   Classe Math
 */
public class CalcolatriceAvanzata {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double memoria;
        double operando = 0;
        char operazione;
        boolean operazioneImpostata;

        char continua = 's';

        do {
            System.out.println("=== CALCOLATRICE JAVA AVANZATA ===");

            // 1️⃣ Primo numero
            System.out.print("Inserisci il primo numero: ");
            memoria = scanner.nextDouble();

            // 2️⃣ Operazione (NON '=')
            System.out.println("\nScegli l'operazione:");
            System.out.println("+  -  *  /  %  ^  r");
            System.out.print("Operazione: ");
            operazione = scanner.next().toLowerCase().charAt(0);
            operazioneImpostata = true;

            // 3️⃣ Secondo numero (se richiesto)
            if (operazione != 'r') {
                System.out.print("Inserisci il secondo numero: ");
                operando = scanner.nextDouble();
            }

            // 4️⃣ Conferma con '='
            System.out.print("Premi '=' per eseguire il calcolo: ");
            char conferma = scanner.next().charAt(0);

            if (conferma != '=') {
                System.err.println("Calcolo annullato: '=' non premuto.");
                operazioneImpostata = false;
            }

            // 5️⃣ Calcolo finale
            if (operazioneImpostata) {

                double risultato = 0;

                switch (operazione) {
                    case '+':
                        risultato = memoria + operando;
                        break;
                    case '-':
                        risultato = memoria - operando;
                        break;
                    case '*':
                        risultato = memoria * operando;
                        break;
                    case '/':
                        if (operando == 0) {
                            System.err.println("Errore: divisione per zero.");
                            operazioneImpostata = false;
                        } else {
                            risultato = memoria / operando;
                        }
                        break;
                    case '%':
                        if (operando == 0) {
                            System.err.println("Errore: modulo per zero.");
                            operazioneImpostata = false;
                        } else {
                            risultato = memoria % operando;
                        }
                        break;
                    case '^':
                        risultato = Math.pow(memoria, operando);
                        break;
                    case 'r':
                        if (memoria < 0) {
                            System.err.println("Errore: radice di numero negativo.");
                            operazioneImpostata = false;
                        } else {
                            risultato = Math.sqrt(memoria);
                        }
                        break;
                    default:
                        System.err.println("Operazione non valida.");
                        operazioneImpostata = false;
                }

                if (operazioneImpostata) {
                    memoria = risultato;
                    System.out.printf("Risultato finale: %.2f%n", memoria);
                }
            }

            // 6️⃣ Continuazione
            System.out.print("\nVuoi continuare? (s/n): ");
            continua = scanner.next().toLowerCase().charAt(0);

            if (continua == 'n') {
                System.out.println("Chiusura della calcolatrice.");
            }

        } while (continua == 's');

        scanner.close();
    }
}
