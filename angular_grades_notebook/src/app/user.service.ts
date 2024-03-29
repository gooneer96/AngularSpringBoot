import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/users';

  constructor(private http: HttpClient) { }

  getuser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createuser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, user);
  }

  updateuser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteuser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getusersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
