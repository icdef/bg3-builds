import {AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { RouterModule } from '@angular/router';
import {MatTabsModule} from '@angular/material/tabs';
import { LootTableComponent } from '../loot-table/loot-table.component';
import { BuildService } from '../../service/build.service';
import { Observable, shareReplay } from 'rxjs';
import { Build } from '../../dto/build';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-loot',
  standalone: true,
  imports: [MatCardModule, RouterModule, MatTabsModule, LootTableComponent, CommonModule],
  templateUrl: './loot.component.html',
  styleUrl: './loot.component.scss'
})

export class LootComponent implements OnInit{
  
  builds$!:Observable<Build[]>;
  
  constructor(private buildService: BuildService){}
  
  ngOnInit(): void {
    this.builds$ = this.buildService.getBuilds().pipe(shareReplay());
  }
}