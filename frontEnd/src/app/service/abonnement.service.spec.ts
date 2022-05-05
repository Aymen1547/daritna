import { TestBed } from '@angular/core/testing';

import { abonnementService } from './abonnement.service';

describe('AbonnementService', () => {
  let service: abonnementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(abonnementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
