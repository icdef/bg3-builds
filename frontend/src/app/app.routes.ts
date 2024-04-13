import { Routes } from '@angular/router';
import { LootComponent } from './component/loot/loot.component';

export const routes: Routes = [
  {
    path: 'loot',
    component: LootComponent,
    title: 'Loot page'
  },

  { 
    path: '',
    redirectTo: '/loot',
    pathMatch: 'full'
  },

  {
    path: '**',
    redirectTo: '/loot',
    pathMatch: 'full'
  }

  

];
