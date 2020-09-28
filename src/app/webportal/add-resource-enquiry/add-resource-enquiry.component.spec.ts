import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddResourceEnquiryComponent } from './add-resource-enquiry.component';

describe('AddResourceEnquiryComponent', () => {
  let component: AddResourceEnquiryComponent;
  let fixture: ComponentFixture<AddResourceEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddResourceEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddResourceEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
