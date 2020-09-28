import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceEnquirySummaryComponent } from './resource-enquiry-summary.component';

describe('ResourceEnquirySummaryComponent', () => {
  let component: ResourceEnquirySummaryComponent;
  let fixture: ComponentFixture<ResourceEnquirySummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResourceEnquirySummaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResourceEnquirySummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
