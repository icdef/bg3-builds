import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Build } from '../dto/build';
import { environment } from '../../environments/environment.development';

const lootBackendUrl = `${environment.backendUrl}/api/v1/builds`;

@Injectable({
  providedIn: 'root'
})
export class BuildService {

  constructor(private http: HttpClient) {}

  public getBuilds(): Observable<Build[]> {
      
    return this.http.get<Build[]>(lootBackendUrl);
  }

}
