import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseEnquirySummaryComponent } from './course-enquiry-summary.component';

describe('CourseEnquirySummaryComponent', () => {
  let component: CourseEnquirySummaryComponent;
  let fixture: ComponentFixture<CourseEnquirySummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CourseEnquirySummaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseEnquirySummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
