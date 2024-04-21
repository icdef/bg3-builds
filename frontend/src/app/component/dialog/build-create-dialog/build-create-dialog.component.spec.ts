import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildCreateDialogComponent } from './build-create-dialog.component';

describe('BuildCreateDialogComponent', () => {
  let component: BuildCreateDialogComponent;
  let fixture: ComponentFixture<BuildCreateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildCreateDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BuildCreateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
