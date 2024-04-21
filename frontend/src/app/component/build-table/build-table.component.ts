import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatCheckbox, MatCheckboxModule } from '@angular/material/checkbox';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';
import { LootItem, LootItemToggle } from '../../dto/lootItem';
import { catchError, throwError } from 'rxjs';
import { BuildService } from '../../service/build.service';
import { Build } from '../../dto/build';

@Component({
  selector: 'app-build-table',
  standalone: true,
  imports: [
    MatExpansionModule,
    MatTableModule,
    MatCheckboxModule,
    CommonModule,
  ],
  templateUrl: './build-table.component.html',
  styleUrl: './build-table.component.scss',
})
export class BuildTableComponent {
  displayedColumns: any = [
    { itemName: 'Name' },
    { itemEffect: 'Item Effect' },
    { itemSource: 'Item Source' },
    { itemLocation: 'Item Location' },
    { subtype: 'Subtype' },
    { type: 'Type' },
  ];

  @Input() build!: Build;
  @Input() act!: number;

  constructor(private readonly buildService: BuildService) {}

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
}
