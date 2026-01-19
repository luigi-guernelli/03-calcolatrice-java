import { Component, HostListener } from '@angular/core';
import { CalcolatriceApiService } from './services/calcolatrice-api.service';

interface CalcButton {
  label: string;
  value: string;
  class: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  /* ===== STATO CALCOLATRICE ===== */
  display = '0';
  errorMessage: string | null = null;

  operando1: number | null = null;
  operazione: string | null = null;
  isSecondOperand = false;
  justCalculated = false;

  /* ===== CRONOLOGIA ===== */
  cronologia: string[] = [];
  showCronologia = false;

  /* ===== TASTIERINO ===== */
  buttons: CalcButton[] = [
    { label: 'C', value: 'C', class: 'btn-control' },
    { label: 'CE', value: 'CE', class: 'btn-control' },
    { label: '%', value: 'percent', class: 'btn-operator' },
    { label: '÷', value: 'div', class: 'btn-operator' },

    { label: '7', value: '7', class: 'btn-number' },
    { label: '8', value: '8', class: 'btn-number' },
    { label: '9', value: '9', class: 'btn-number' },
    { label: '×', value: 'mul', class: 'btn-operator' },

    { label: '4', value: '4', class: 'btn-number' },
    { label: '5', value: '5', class: 'btn-number' },
    { label: '6', value: '6', class: 'btn-number' },
    { label: '−', value: 'sub', class: 'btn-operator' },

    { label: '1', value: '1', class: 'btn-number' },
    { label: '2', value: '2', class: 'btn-number' },
    { label: '3', value: '3', class: 'btn-number' },
    { label: '+', value: 'add', class: 'btn-operator' },

    { label: '0', value: '0', class: 'btn-number col-6' },
    { label: '.', value: '.', class: 'btn-number' },
    { label: '=', value: '=', class: 'btn-equals col-6' }
  ];

  constructor(private api: CalcolatriceApiService) {}


  /* ===== INPUT ===== */
  onButtonClick(value: string): void {
    if (/^[0-9.]$/.test(value)) return this.inputDigit(value);
    if (value === '=') return this.calculate();
    if (value === 'C') return this.clearAll();
    if (value === 'CE') return this.clearEntry();
    this.setOperation(value);
  }

  inputDigit(digit: string): void {
    if (this.isSecondOperand || this.justCalculated) {
      this.display = digit;
      this.isSecondOperand = false;
      this.justCalculated = false;
    } else {
      this.display = this.display === '0' ? digit : this.display + digit;
    }
  }

  setOperation(op: string): void {
    if (this.operazione && !this.isSecondOperand) {
      this.calculate();
    }

    this.operando1 = parseFloat(this.display);
    this.operazione = op;
    this.isSecondOperand = true;
    this.justCalculated = false;
  }

  /* ===== CALCOLO ===== */
  calculate(): void {
  this.errorMessage = null;

  if (this.operazione === null || this.operando1 === null) return;

  const operando2 = parseFloat(this.display);
  if (isNaN(operando2)) return;

  this.api.calcola(this.operando1, operando2, this.operazione)
    .subscribe({
      next: res => {
        if (res.errore) {
          this.errorMessage = res.errore;
          return;
        }

        const result = res.risultato;

        this.cronologia.unshift(
          `${this.operando1} ${this.getSymbol(this.operazione)} ${operando2} = ${result}`
        );

        this.display = result.toString();
        this.operando1 = result;
        this.operazione = null;
        this.isSecondOperand = true;
        this.justCalculated = true;
      },
      error: () => {
        this.errorMessage = 'Errore di comunicazione con il server';
      }
    });
}

  /* ===== UTILS ===== */
  clearAll(): void {
    this.display = '0';
    this.operando1 = null;
    this.operazione = null;
    this.isSecondOperand = false;
    this.justCalculated = false;
    this.errorMessage = null;
  }

  clearEntry(): void {
    this.display = '0';
  }

  toggleCronologia(): void {
    this.showCronologia = !this.showCronologia;
  }

  clearCronologia(): void {
    this.cronologia = [];
  }

  getSymbol(op: string | null): string {
    if (!op) return '';
    return {
      add: '+',
      sub: '−',
      mul: '×',
      div: '÷',
      percent: '%'
    }[op] || '';
  }

  /* ===== TASTIERA ===== */
  @HostListener('document:keydown', ['$event'])
  handleKeyboard(event: KeyboardEvent): void {
    const key = event.key;

    if (/^[0-9.]$/.test(key)) return this.inputDigit(key);
    if (key === '=' || key === 'Enter') return this.calculate();
    if (key === 'Escape') return this.clearAll();
    if (key === 'Backspace') return this.clearEntry();

    const operatorMap: Record<string, string> = {
      '+': 'add',
      '-': 'sub',
      '*': 'mul',
      '/': 'div',
      '%': 'percent'
    };

    if (operatorMap[key]) this.setOperation(operatorMap[key]);
  }
}
