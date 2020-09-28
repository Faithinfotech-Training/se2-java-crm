import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerSalespipelineComponent } from './manager-salespipeline.component';

describe('ManagerSalespipelineComponent', () => {
  let component: ManagerSalespipelineComponent;
  let fixture: ComponentFixture<ManagerSalespipelineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerSalespipelineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerSalespipelineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
