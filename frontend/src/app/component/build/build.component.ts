import { Component, Inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BuildService } from '../../service/build.service';
import { Observable, tap } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { Build } from '../../dto/build';
import { MatExpansionModule } from '@angular/material/expansion';
import { BuildTableComponent } from '../build-table/build-table.component';
import { MatButtonModule } from '@angular/material/button';
import { BuildNameDialogComponent } from '../dialog/build-name-dialog/build-name-dialog.component';
import { MatIconModule } from '@angular/material/icon';
import { ConfirmationDialogComponent } from '../dialog/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-build',
  standalone: true,
  imports: [
    CommonModule,
    MatExpansionModule,
    BuildTableComponent,
    MatButtonModule,
    MatIconModule,
  ],
  templateUrl: './build.component.html',
  styleUrl: './build.component.scss',
})
export class BuildComponent implements OnInit {
  builds$!: Observable<Build[]>;
  constructor(private buildService: BuildService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.builds$ = this.buildService.getBuilds();
  }

  createNewBuild(buildName: string) {
    this.buildService
      .createBuild({ name: buildName })
      .pipe(tap(() => (this.builds$ = this.buildService.getBuilds())))
      .subscribe();
  }

  updateBuild(buildName: string, buildId: number) {
    this.buildService
      .updateBuildName(buildName, buildId)
      .pipe(tap(() => (this.builds$ = this.buildService.getBuilds())))
      .subscribe();
  }

  deleteBuild(buildId: number) {
    this.buildService
      .deleteBuild(buildId)
      .pipe(tap(() => (this.builds$ = this.buildService.getBuilds())))
      .subscribe();
  }

  createBuildEvent(): void {
    const dialogRef = this.dialog.open(BuildNameDialogComponent);
    dialogRef.afterClosed().subscribe((buildName: string) => {
      if (buildName && buildName.trim().length != 0) {
        this.createNewBuild(buildName);
      }
    });
  }
  editNameEvent(event: any, buildId: number, currentBuildName: string) {
    event.stopPropagation();
    const dialogRef = this.dialog.open(BuildNameDialogComponent, {
      data: currentBuildName,
    });
    dialogRef.afterClosed().subscribe((buildName: string) => {
      if (buildName && buildName.trim().length != 0) {
        this.updateBuild(buildName, buildId);
      }
    });
  }
  deleteBuildEvent(event: any, buildId: number, buildName: string) {
    event.stopPropagation();
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: `Are you sure you want to delete ${buildName}?`,
    });
    dialogRef.afterClosed().subscribe((confirmation: boolean) => {
      if (confirmation) {
        this.deleteBuild(buildId);
      }
    });
  }
}
