import java.util.Scanner;

/**
 * Classe Main unica per eseguire il programma Utillizzare i precedenti progetti
 * per lo sviluppo P01-P05: Main, Tipi, Variabili, Scanner, Operatori Aritmetici
 */
public class CalcolatriceBase {

	public static void main(String[] args) {

		// Utilizzo della classe Scanner per permette all'utentete di inserire valori in
		// input
		Scanner scanner = new Scanner(System.in);

		// Condizione del ciclo do-while che permette di continuare o di uscire dal
		// programma
		char continua = 's';
		do {
			System.out.println("=== CALCOLATRICE BASE JAVA ===");
			System.out.println("=======================" + "\n||                 0.||" + "\n======================="
					+ "\n|| 1 | 2 | 3 | + | - ||" + "\n|| 4 | 5 | 6 | * | / ||" + "\n|| 7 | 8 | 9 | % | ^ ||"
					+ "\n|| , | 0 | . | x | = ||" + "\n=======================");

			System.out.print("Inserisci il primo numero: ");
			double numero1 = scanner.nextDouble();

			System.out.println("Scegli l'operazione che vuoi utilizzare:");
			System.out.println("+ ADDIZIONE;");
			System.out.println("- SOTTRAZIONE;");
			System.out.println("* MOLTIPLICAZIONE;");
			System.out.println("/ DIVISIONE;");
			System.out.println("% MODULO;");
			System.out.print("Inserisci il carattere dell' operazione: ");
			char carattereOperazione = scanner.next().charAt(0);

			System.out.print("Inserisci il secondo numero: ");
			double numero2 = scanner.nextDouble();

			// Gestione dell'operazione scelta dall'utente tramite selezione su carattere
			// Ogni 'case' rappresenta un'operazione aritmetica distinta
			switch (carattereOperazione) {
			case '+': // Calcolo della somma tra i due numeri inseriti dall'utente e stampa il
						// risultato
				double addizione = numero1 + numero2;
				System.out.println("La somma dei due numeri è: " + addizione);
				break;
			case '-': // Calcolo la differenza tra il primo e il secondo numero
				double sottrazione = numero1 - numero2;
				System.out.println("La sottrazione dei due numeri è: " + sottrazione);
				break;
			case '*': // Calcolo del prodotto dei numeri
				double moltiplicazione = (numero1 * numero2);
				System.out.println("La moltiplicazione tra i due numeri è: " + moltiplicazione);
				break;
			case '/': // Verifica che il divisore sia diverso da zero prima di eseguire la divisione
				// if else :
				// - Controllo divisione per zero
				// - Separazione tra errore e calcolo valido
				if (numero2 == 0) {
					System.err.println("Il secondo numero non puo essere zero: " + numero2);
				} else {
					double divisione = numero1 / numero2;
					System.out.println("La divisione dei due numeri è: " + divisione);
				}
				break;
			case '%': // Calcolo del resto della divisione (operatore modulo) con controllo sul
						// divisiore
				if (numero2 == 0) {
					System.err.println("Il secondo numero non puo essere zero: " + numero2);
				} else {
					double modulo = numero1 % numero2;
					System.out.println("Il modulo ha restuito il resto dei due numeri in: " + modulo);
				}
				break;
			default: // Gestione di un input non previsto per l'operazione
				System.err.println("Operazione non valida");
			}

			System.out.print("Vuoi uscire dalla calcolatrice Digita 's' per continuare /'n' per uscire: \n");
			continua = scanner.next().toLowerCase().charAt(0);
			if (continua == 'n') {
				System.out.println("Chiusura della calcolatrice JavaBase!");
			}
		} while (continua == 's');

		scanner.close();

	}

}
