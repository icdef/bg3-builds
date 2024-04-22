import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Build } from '../dto/build';
import { environment } from '../../environments/environment.development';
import { LootItemToggle } from '../dto/lootItem';
import { CreateBuild } from '../dto/createBuild';

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
      `${lootBackendUrl}/${buildId}/lootItemToggle`,
      lootItemToggle
    );
  }

  public createBuild(createBuildDto: CreateBuild): Observable<Build> {
    return this.http.post<Build>(lootBackendUrl, createBuildDto);
  }

  public updateBuildName(name: string, buildId: number): Observable<Build> {
    return this.http.put<Build>(`${lootBackendUrl}/${buildId}/rename`, {
      name: name,
    });
  }

  public deleteBuild(buildId: number): Observable<void> {
    return this.http.delete<void>(`${lootBackendUrl}/${buildId}`);
  }
}
