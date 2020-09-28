import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourseSalesComponent } from './resourse-sales.component';

describe('ResourseSalesComponent', () => {
  let component: ResourseSalesComponent;
  let fixture: ComponentFixture<ResourseSalesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResourseSalesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResourseSalesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
