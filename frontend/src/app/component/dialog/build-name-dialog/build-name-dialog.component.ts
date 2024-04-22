import { Component, Inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
  MatDialogRef,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-build-name-dialog',
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
  templateUrl: './build-name-dialog.component.html',
  styleUrl: './build-name-dialog.component.scss',
})
export class BuildNameDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<BuildNameDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public name: string
  ) {}
  buildName: string = this.name;

  onNoClick(): void {
    this.dialogRef.close();
  }
}
