import { TestBed } from '@angular/core/testing';

import { ResourceEnquirySummaryService } from './resource-enquiry-summary.service';

describe('ResourceEnquirySummaryService', () => {
  let service: ResourceEnquirySummaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResourceEnquirySummaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
