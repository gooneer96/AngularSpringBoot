import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GradeService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/grades';

  constructor(private http: HttpClient) { }

  getGrade(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  addGrade(grade: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, grade);
  }

  showGrade(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/bystudent/${id}`);
  }

  updateGrade(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteGrade(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

}
