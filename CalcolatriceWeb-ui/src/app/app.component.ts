import { Component } from '@angular/core';
import { CalcolatriceService } from './services/calcolatrice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  numero1!: number;
  numero2!: number;
  operazione: string = 'add';

  risultato: number | null = null;
  errore: string | null = null;

  constructor(private calcolatriceService: CalcolatriceService) {}

  calcola() {

    this.risultato = null;
    this.errore = null;

    this.calcolatriceService
      .calcola(this.numero1, this.numero2, this.operazione)
      .subscribe({
        next: (response) => {
          this.risultato = response.risultato;
          this.errore = response.errore;
        },
        error: () => {
          this.errore = 'Errore di comunicazione con il server';
        }
      });
  }
}
