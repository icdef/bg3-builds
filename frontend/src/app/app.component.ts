import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './component/navbar/navbar.component';
import { LootComponent } from './component/loot/loot.component';
import { CommonModule } from '@angular/common';
import { ThemeService } from './service/theme.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, LootComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  constructor(private readonly themeService: ThemeService) {}

  getThemeSignal(): string {
    return this.themeService.themeSignal();
  }
}
