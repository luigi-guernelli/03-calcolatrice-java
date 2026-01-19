import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class CalcolatriceApiService {

  private apiUrl = 'http://localhost:8080/api/calcolatrice/calcola';

  constructor(private http: HttpClient) {}

  calcola(a: number, b: number, operazione: string) {
    return this.http.post<any>(this.apiUrl, {
      a,
      b,
      operazione
    });
  }
}
