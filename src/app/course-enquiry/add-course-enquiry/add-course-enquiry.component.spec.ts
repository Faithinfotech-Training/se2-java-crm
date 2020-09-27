import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCourseEnquiryComponent } from './add-course-enquiry.component';

describe('AddCourseEnquiryComponent', () => {
  let component: AddCourseEnquiryComponent;
  let fixture: ComponentFixture<AddCourseEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCourseEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCourseEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
