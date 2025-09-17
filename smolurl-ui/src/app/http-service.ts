import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface CreateResponse {
  id: string;
}

@Injectable({
  providedIn: 'root',
})
export class HttpService {

  private http = inject(HttpClient);

  private baseUrl = '/api';

  constructor() {}

  postCreate(url: string): Observable<CreateResponse> {
    return this.http.post<CreateResponse>(`${this.baseUrl}/create`, { url });
  }

}

