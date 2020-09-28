import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebportalComponent } from './webportal.component';

describe('WebportalComponent', () => {
  let component: WebportalComponent;
  let fixture: ComponentFixture<WebportalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WebportalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WebportalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
