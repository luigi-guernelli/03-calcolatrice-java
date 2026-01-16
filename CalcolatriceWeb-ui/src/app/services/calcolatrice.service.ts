import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalcolatriceService {

  private apiUrl = 'http://localhost:8080/api/calcolatrice/calcola';

  constructor(private http: HttpClient) {}

  calcola(a: number, b: number | null, operazione: string) {

    let params = new HttpParams()
      .set('a', a)
      .set('operazione', operazione);

    if (operazione !== 'sqrt' && b !== null) {
      params = params.set('b', b);
    }

    return this.http.get<any>(this.apiUrl, { params });
  }
}
