import { Routes } from '@angular/router';
import { LootComponent } from './component/loot/loot.component';
import { BuildComponent } from './component/build/build.component';

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
    path: 'build',
    component: BuildComponent,
    title: 'Build page'
  },

  {
    path: '**',
    redirectTo: '/loot',
    pathMatch: 'full'
  }

  

];
