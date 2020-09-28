import { TestBed } from '@angular/core/testing';

import { CourseEnquirySummaryService } from './course-enquiry-summary.service';

describe('CourseEnquirySummaryService', () => {
  let service: CourseEnquirySummaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CourseEnquirySummaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
