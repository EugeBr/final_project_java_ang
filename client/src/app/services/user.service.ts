import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly API_URL = "http://localhost:8888/api/users";

  constructor(private http: HttpClient) { }

  getUserCoffees(id : number) : Observable<any> {
    return this.http.get(`${this.API_URL}/${id}/coffees`);
  }

  getUserById(id : number) : Observable<any> {
    return this.http.get(`${this.API_URL}/${id}`);
  }

  updateUser(id : number, formData: any) {
    return this.http.put(`${this.API_URL}/${id}`, formData);
  }

  deleteUser(id : number) : Observable<any> {
    return this.http.delete(`${this.API_URL}/${id}`);
  }

  login(formData: any) : Observable<any> {
    return this.http.patch(`${this.API_URL}/login`, formData);
  }

  register(formData: any) : Observable<any> {
    return this.http.post(`${this.API_URL}`, formData);
  }
}
