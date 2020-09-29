import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceEnquiryComponent } from './resource-enquiry.component';

describe('ResourceEnquiryComponent', () => {
  let component: ResourceEnquiryComponent;
  let fixture: ComponentFixture<ResourceEnquiryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResourceEnquiryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResourceEnquiryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
