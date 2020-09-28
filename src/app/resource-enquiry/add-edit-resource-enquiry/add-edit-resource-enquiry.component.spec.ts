import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditResourceEnquiryComponent } from './add-edit-resource-enquiry.component';

describe('AddEditResourceEnquiryComponent', () => {
  let component: AddEditResourceEnquiryComponent;
  let fixture: ComponentFixture<AddEditResourceEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEditResourceEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditResourceEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
