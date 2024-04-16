import {AfterViewInit, Component, ViewChild, Input,OnChanges, SimpleChanges, EventEmitter, OnDestroy, OnInit } from '@angular/core';
import {MatTableModule, MatTableDataSource} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatPaginator, MatPaginatorModule, PageEvent} from '@angular/material/paginator';
import {MatIconModule} from '@angular/material/icon'
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { RouterModule } from '@angular/router';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatTabsModule} from '@angular/material/tabs';
import { PeriodicElement } from '../../dto/periodic-element';
import { LootService } from '../../service/loot.service';
import { merge, Observable, of as observableOf, pipe, Subject } from 'rxjs';
import { catchError, map, shareReplay, startWith, switchMap, takeUntil } from 'rxjs/operators';
import { Loot } from '../../dto/loot';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatMenuModule} from '@angular/material/menu';
import { FormsModule } from '@angular/forms';
import { Build } from '../../dto/build';
import { BuildService } from '../../service/build.service';

type filterMode = '' | 'Weapon' | 'Equipment'

@Component({
  selector: 'app-loot-table',
  standalone: true,
  imports: [MatTableModule, MatFormFieldModule, MatInputModule, MatPaginatorModule, 
    MatIconModule, MatButtonModule, MatCardModule, RouterModule, MatButtonToggleModule,
  MatTabsModule, CommonModule, MatProgressBarModule, FormsModule, MatMenuModule],
  templateUrl: './loot-table.component.html',
  styleUrl: './loot-table.component.scss'
})
export class LootTableComponent implements AfterViewInit, OnDestroy{

  private ngUnsubscribe = new Subject<void>();

  displayedColumns: any = [{'itemName': 'Name'}, {'itemEffect':'Item Effect'}, {'itemSource': 'Item Source'},
   {'itemLocation':'Item Location'}, {'subtype': 'Subtype'}, {'type': 'Type'},];

  @Input() act! :number;
  @Input() builds!: Build[] | null;
  dataSource!:MatTableDataSource<Loot>;
  queryfilter: filterMode = '';
  totalData!: number;
  isLoading = true;
  filterText: string = '';
 
  constructor(private lootService: LootService){}


  @ViewChild(MatPaginator)
  paginator!: MatPaginator;


  ngAfterViewInit() {
    this.paginator.page
      .pipe(
        startWith({}),
        switchMap(() => {
          return this.getTableData$(
            this.act,
            this.queryfilter,
            this.paginator.pageIndex,
            this.paginator.pageSize
          ).pipe(catchError(() => observableOf(null)));
        }),
        map((lootTableData) => {
          if (lootTableData == null) return [];
          this.totalData = lootTableData.total;
          this.filterText = "";
          return lootTableData.data;
        }),
        takeUntil(this.ngUnsubscribe)
      )
      .subscribe((lootData) => {
        this.dataSource = new MatTableDataSource(lootData);
        this.dataSource.filterPredicate = (data: Loot, filter: string) => {
      return data.itemName.toLowerCase().indexOf(filter) != -1;
    }
    this.isLoading = false;
      });
  }

  ngOnDestroy(): void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  getTableData$(act: number, typeKind: string, pageNumber: number, pageSize: number) {
    return this.lootService.getLoot(act, typeKind,pageNumber, pageSize);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  clearFilter() {
    this.filterText = "";
    this.dataSource.filter = '';
  }

  weaponOnly() {
    this.queryfilter = 'Weapon'
    this.paginator.pageIndex = 0;
    this.paginator.page.emit();
  }
  equipmentOnly() {
    this.queryfilter = 'Equipment'
    this.paginator.pageIndex = 0;
    this.paginator.page.emit();

  }
  allData() {
   this.queryfilter = '';
   this.paginator.page.emit();
  }

  getColumnKey(column: any) {
    return Object.keys(column)[0];
  }

  getColumnHeaderValue(column: any) {;
    return this.displayedColumns.find((c: any) => c[column] != undefined)[column]
  }
  getColumnValue(loot: any, column: any):string {
    if (loot[column] !== undefined)
      return loot[column];
    return loot.lootItemDetail[column];
  }

  getDisplayedColumnKeys() {
    return this.displayedColumns.map((column: any) => this.getColumnKey(column));
  }

  edit(test: any){
    console.log(test);
  }

}
