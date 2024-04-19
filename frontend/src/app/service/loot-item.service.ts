import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LootTable } from '../dto/lootTable';

const lootBackendUrl = `${environment.backendUrl}/api/v1/loot`;

@Injectable({
  providedIn: 'root',
})
export class LootItemService {
  constructor(private readonly http: HttpClient) {}

  public getLoot(
    act: number,
    queryFilter: string,
    typeKind: string,
    pageNumber: number,
    pageSize: number
  ): Observable<LootTable> {
    let params = new HttpParams()
      .set('act', act)
      .set('queryFilter', queryFilter)
      .set('typeKind', typeKind)
      .set('pageNumber', pageNumber)
      .set('pageSize', pageSize);

    return this.http.get<LootTable>(lootBackendUrl, { params: params });
  }
}
