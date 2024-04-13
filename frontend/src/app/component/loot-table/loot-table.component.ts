import {AfterViewInit, Component, ViewChild, Input,OnChanges, SimpleChanges } from '@angular/core';
import {MatTableModule, MatTableDataSource} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatIconModule} from '@angular/material/icon'
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { RouterModule } from '@angular/router';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatTabsModule} from '@angular/material/tabs';
import { PeriodicElement } from '../../dto/periodic-element';

@Component({
  selector: 'app-loot-table',
  standalone: true,
  imports: [MatTableModule, MatFormFieldModule, MatInputModule, MatPaginatorModule, 
    MatIconModule, MatButtonModule, MatCardModule, RouterModule, MatButtonToggleModule,
  MatTabsModule],
  templateUrl: './loot-table.component.html',
  styleUrl: './loot-table.component.scss'
})
export class LootTableComponent implements AfterViewInit, OnChanges{



  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  @Input() data! :PeriodicElement[];
  dataSource!:MatTableDataSource<PeriodicElement>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  ngOnChanges(changes: SimpleChanges): void {
    this.dataSource = new MatTableDataSource<PeriodicElement>(this.data);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.filterPredicate = (data: PeriodicElement, filter: string) => {
      return data.name.toLowerCase().indexOf(filter) != -1;
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  clearFilter(input: HTMLInputElement) {
    input.value = '';
    this.dataSource.filter = '';
  }

  biggerThan10() {
    this.dataSource.data = this.data.filter(x=> x.weight > 10);
  }
  smallerThan10() {
    this.dataSource.data = this.data.filter(x=> x.weight < 10);
  }
  allData() {
    this.dataSource.data = this.data;
  }

}
