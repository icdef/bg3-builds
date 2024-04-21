import { Component, Inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BuildService } from '../../service/build.service';
import { Observable, tap } from 'rxjs';
import {
  MatDialog,
  MatDialogRef,
  MatDialogActions,
  MatDialogClose,
  MatDialogTitle,
  MatDialogContent,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { Build } from '../../dto/build';
import { MatExpansionModule } from '@angular/material/expansion';
import { BuildTableComponent } from '../build-table/build-table.component';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BuildCreateDialogComponent } from '../dialog/build-create-dialog/build-create-dialog.component';

@Component({
  selector: 'app-build',
  standalone: true,
  imports: [
    CommonModule,
    MatExpansionModule,
    BuildTableComponent,
    MatButtonModule,
  ],
  templateUrl: './build.component.html',
  styleUrl: './build.component.scss',
})
export class BuildComponent implements OnInit {
  builds$!: Observable<Build[]>;
  constructor(private buildService: BuildService, private dialog: MatDialog) {}
  buildName: string = '';
  ngOnInit(): void {
    this.builds$ = this.buildService.getBuilds();
  }

  createNewBuild(buildName: string) {
    this.buildService
      .createBuild({ name: buildName })
      .pipe(tap(() => (this.builds$ = this.buildService.getBuilds())))
      .subscribe();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(BuildCreateDialogComponent);
    dialogRef.afterClosed().subscribe((buildName: string) => {
      if (buildName && buildName.trim().length != 0)
        this.createNewBuild(buildName);
    });
  }
}
