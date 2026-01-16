import { TestBed } from '@angular/core/testing';

import { CalcolatriceService } from './calcolatrice.service';

describe('CalcolatriceService', () => {
  let service: CalcolatriceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalcolatriceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
