import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBanksComponent } from './update-banks.component';

describe('UpdateBanksComponent', () => {
  let component: UpdateBanksComponent;
  let fixture: ComponentFixture<UpdateBanksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateBanksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBanksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
