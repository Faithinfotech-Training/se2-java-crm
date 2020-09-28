import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewResourceEnquiryComponent } from './view-resource-enquiry.component';

describe('ViewResourceEnquiryComponent', () => {
  let component: ViewResourceEnquiryComponent;
  let fixture: ComponentFixture<ViewResourceEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewResourceEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewResourceEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
