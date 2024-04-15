import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LootTable } from '../dto/loot';

const lootBackendUrl = `${environment.backendUrl}/api/v1/gear`;

@Injectable({
  providedIn: 'root',
})
export class LootService {

  constructor(private http: HttpClient) {}

  public getLoot(act: number, typeKind: string, pageNumber: number, pageSize: number): Observable<LootTable> {
    let params = new HttpParams()
    .set('act',act)
    .set('typeKind',typeKind)
    .set('pageNumber', pageNumber)
    .set('pageSize',pageSize);

  
    return this.http.get<LootTable>(lootBackendUrl,{params: params});
  }
}
