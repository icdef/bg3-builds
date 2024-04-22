import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildNameDialogComponent } from './build-name-dialog.component';

describe('BuildCreateDialogComponent', () => {
  let component: BuildNameDialogComponent;
  let fixture: ComponentFixture<BuildNameDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildNameDialogComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(BuildNameDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
