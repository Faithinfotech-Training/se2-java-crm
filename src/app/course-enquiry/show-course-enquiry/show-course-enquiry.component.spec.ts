import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCourseEnquiryComponent } from './show-course-enquiry.component';

describe('ShowCourseEnquiryComponent', () => {
  let component: ShowCourseEnquiryComponent;
  let fixture: ComponentFixture<ShowCourseEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowCourseEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCourseEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
