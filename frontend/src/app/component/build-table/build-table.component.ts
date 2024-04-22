import { CommonModule } from '@angular/common';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatCheckbox, MatCheckboxModule } from '@angular/material/checkbox';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTable, MatTableModule } from '@angular/material/table';
import { LootItem, LootItemToggle } from '../../dto/lootItem';
import { catchError, tap, throwError } from 'rxjs';
import { BuildService } from '../../service/build.service';
import { Build } from '../../dto/build';
import { SnackbarService } from '../../service/snackbar.service';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../dialog/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-build-table',
  standalone: true,
  imports: [
    MatExpansionModule,
    MatTableModule,
    MatCheckboxModule,
    CommonModule,
    MatButtonModule,
    MatIconModule,
  ],
  templateUrl: './build-table.component.html',
  styleUrl: './build-table.component.scss',
})
export class BuildTableComponent implements OnInit {
  displayedColumns: any = [
    { itemName: 'Name' },
    { itemEffect: 'Effect' },
    { itemSource: 'Source' },
    { itemLocation: 'Location' },
    { subtype: 'Subtype' },
    { type: 'Type' },
  ];

  @Input() build!: Build;
  @Input() act!: number;
  @ViewChild(MatTable) table!: MatTable<LootItem>;

  dataSource!: LootItem[];

  constructor(
    private readonly buildService: BuildService,
    private readonly snackBarService: SnackbarService,
    private dialog: MatDialog
  ) {}
  ngOnInit(): void {
    this.dataSource = this.filterLootItems(this.build.items, this.act);
  }

  filterLootItems(items: LootItem[], act: number): LootItem[] {
    return items.filter((item) => item.act === act);
  }

  getColumnKey(column: any) {
    return Object.keys(column)[0];
  }

  getColumnHeaderValue(column: any) {
    return this.displayedColumns.find((c: any) => c[column] != undefined)[
      column
    ];
  }
  getColumnValue(loot: any, column: any): string {
    if (loot[column] !== undefined) return loot[column];
    return loot.lootItemDetail[column];
  }

  getDisplayedColumnKeys() {
    return this.displayedColumns.map((column: any) =>
      this.getColumnKey(column)
    );
  }
  toggleSelection(
    buildId: number,
    lootItem: LootItemToggle,
    check: MatCheckbox
  ) {
    lootItem.isLooted = !lootItem.isLooted;
    this.buildService
      .updateLootItemLootedFlag(buildId, lootItem)
      .pipe(
        catchError((errr: any) => {
          check.checked = false;
          // revert local change
          lootItem.isLooted = !lootItem.isLooted;
          const err = new Error(errr);
          return throwError(() => errr);
        })
      )
      .subscribe();
  }

  removeItemFromBuild(item: LootItem, build: Build) {
    this.buildService
      .removeItemFromBuild(item, build.id)
      .pipe(
        tap(() => {
          this.snackBarService.openSnackBar(
            `Removed ${item.itemName} from ${build.name}`
          );
          const index = this.dataSource.indexOf(item, 0);
          this.dataSource.splice(index, 1);
          this.table.renderRows();
        })
      )
      .subscribe();
  }
  removeItemFromBuildEvent(item: LootItem, build: Build) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: `Are you sure you want to remove ${item.itemName} from ${build.name}?`,
    });
    dialogRef.afterClosed().subscribe((confirmation: boolean) => {
      if (confirmation) {
        this.removeItemFromBuild(item, build);
      }
    });
  }
}
