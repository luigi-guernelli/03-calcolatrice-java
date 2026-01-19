import { TestBed } from '@angular/core/testing';

import { CalcolatriceApiService } from './calcolatrice-api.service';

describe('CalcolatriceApiService', () => {
  let service: CalcolatriceApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalcolatriceApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
