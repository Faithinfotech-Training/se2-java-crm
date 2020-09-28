import { TestBed } from '@angular/core/testing';

import { ResourceEnquiryService } from './resource-enquiry.service';

describe('ResourceEnquiryService', () => {
  let service: ResourceEnquiryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResourceEnquiryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
