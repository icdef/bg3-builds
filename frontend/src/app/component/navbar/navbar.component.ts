import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterOutlet } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { ThemeService } from '../../service/theme.service';
import { MatIconModule } from '@angular/material/icon';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    MatToolbarModule,
    RouterOutlet,
    MatButtonModule,
    RouterModule,
    MatIconModule,
    MatSlideToggleModule,
    CommonModule,
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss',
})
export class NavbarComponent {
  constructor(private readonly themeService: ThemeService) {}

  toggleTheme() {
    this.themeService.toggleTheme();
  }
  getTheme(): string {
    return this.themeService.themeSignal();
  }

  setPrimaryColorIfLightMode(): string {
    return this.themeService.setPrimaryColorIfLightMode();
  }
}
