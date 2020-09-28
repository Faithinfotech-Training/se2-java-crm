import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebCourseEnquiryFormComponent } from './web-course-enquiry-form.component';

describe('WebCourseEnquiryFormComponent', () => {
  let component: WebCourseEnquiryFormComponent;
  let fixture: ComponentFixture<WebCourseEnquiryFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WebCourseEnquiryFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WebCourseEnquiryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
