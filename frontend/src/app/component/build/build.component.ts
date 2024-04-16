import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BuildService } from '../../service/build.service';
import { Observable } from 'rxjs';
import { Build } from '../../dto/build';
import {MatCardModule} from '@angular/material/card';
import {MatExpansionModule} from '@angular/material/expansion';

@Component({
  selector: 'app-build',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatExpansionModule],
  templateUrl: './build.component.html',
  styleUrl: './build.component.scss'
})
export class BuildComponent implements OnInit{

  builds$!:Observable<Build[]>;
  constructor(private buildService: BuildService){}


  ngOnInit(): void {
    this.builds$ = this.buildService.getBuilds();
  }

}
