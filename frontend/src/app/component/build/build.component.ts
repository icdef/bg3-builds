import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BuildService } from '../../service/build.service';
import { Observable, catchError, filter, map, tap, throwError } from 'rxjs';
import { Build } from '../../dto/build';
import { MatCardModule } from '@angular/material/card';
import { MatExpansionModule } from '@angular/material/expansion';
import { LootItem, LootItemToggle } from '../../dto/lootItem';
import { MatTableModule } from '@angular/material/table';
import { MatDividerModule } from '@angular/material/divider';
import { MatIcon } from '@angular/material/icon';
import { MatCheckbox, MatCheckboxModule } from '@angular/material/checkbox';

@Component({
  selector: 'app-build',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatExpansionModule,
    MatTableModule,
    MatDividerModule,
    MatIcon,
    MatCheckboxModule,
  ],
  templateUrl: './build.component.html',
  styleUrl: './build.component.scss',
})
export class BuildComponent implements OnInit {
  builds$!: Observable<Build[]>;

  displayedColumns: any = [
    { itemName: 'Name' },
    { itemEffect: 'Item Effect' },
    { itemSource: 'Item Source' },
    { itemLocation: 'Item Location' },
    { subtype: 'Subtype' },
    { type: 'Type' },
  ];

  constructor(private buildService: BuildService) {}

  ngOnInit(): void {
    this.builds$ = this.buildService.getBuilds();
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
}
