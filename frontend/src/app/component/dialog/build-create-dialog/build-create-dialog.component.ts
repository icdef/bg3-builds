import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {
  MatDialog,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
  MatDialogRef,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BuildService } from '../../../service/build.service';

@Component({
  selector: 'app-build-create-dialog',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatButtonModule,
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,
  ],
  templateUrl: './build-create-dialog.component.html',
  styleUrl: './build-create-dialog.component.scss',
})
export class BuildCreateDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<BuildCreateDialogComponent>,
    private buildService: BuildService
  ) {}
  buildName: string = '';

  onNoClick(): void {
    this.dialogRef.close();
  }
}
