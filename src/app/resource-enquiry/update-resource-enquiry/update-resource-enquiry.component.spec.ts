import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateResourceEnquiryComponent } from './update-resource-enquiry.component';

describe('UpdateResourceEnquiryComponent', () => {
  let component: UpdateResourceEnquiryComponent;
  let fixture: ComponentFixture<UpdateResourceEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateResourceEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateResourceEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
