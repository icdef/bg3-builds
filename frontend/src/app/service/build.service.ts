import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Build } from '../dto/build';
import { environment } from '../../environments/environment.development';
import { LootItemToggle } from '../dto/lootItem';
import { CreateBuildDto } from '../dto/createBuildDto';

const lootBackendUrl = `${environment.backendUrl}/api/v1/builds`;

@Injectable({
  providedIn: 'root',
})
export class BuildService {
  constructor(private readonly http: HttpClient) {}

  public getBuilds(): Observable<Build[]> {
    return this.http.get<Build[]>(lootBackendUrl);
  }

  public updateLootItemLootedFlag(
    buildId: number,
    lootItemToggle: LootItemToggle
  ): Observable<LootItemToggle> {
    return this.http.put<LootItemToggle>(
      `${lootBackendUrl}/${buildId}`,
      lootItemToggle
    );
  }

  public createBuild(createBuildDto: CreateBuildDto): Observable<Build> {
    return this.http.post<Build>(lootBackendUrl, createBuildDto);
  }
}
