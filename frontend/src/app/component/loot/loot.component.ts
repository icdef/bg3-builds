import {AfterViewInit, Component, ViewChild } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { RouterModule } from '@angular/router';
import {MatTabsModule} from '@angular/material/tabs';
import { LootTableComponent } from '../loot-table/loot-table.component';
import { PeriodicElement } from '../../dto/periodic-element';
import { LootService } from '../../service/loot.service';

@Component({
  selector: 'app-loot',
  standalone: true,
  imports: [MatCardModule, RouterModule, MatTabsModule, LootTableComponent],
  templateUrl: './loot.component.html',
  styleUrl: './loot.component.scss'
})

export class LootComponent{

}