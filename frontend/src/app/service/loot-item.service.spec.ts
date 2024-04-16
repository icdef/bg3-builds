import { TestBed } from '@angular/core/testing';

import { LootService } from './loot-item.service';

describe('LootService', () => {
  let service: LootService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LootService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
