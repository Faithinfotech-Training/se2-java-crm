import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCourseEnquiryComponent } from './update-course-enquiry.component';

describe('UpdateCourseEnquiryComponent', () => {
  let component: UpdateCourseEnquiryComponent;
  let fixture: ComponentFixture<UpdateCourseEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCourseEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCourseEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
