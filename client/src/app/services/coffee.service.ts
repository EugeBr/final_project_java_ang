import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CoffeeService {

  private readonly API_URL = "http://localhost:8888/api/coffees";

  constructor(private http: HttpClient) { }

  getCoffees() : Observable<any>{
    return this.http.get(`${this.API_URL}`);
  }

  createCoffee(formData: any) {
    return this.http.post(`${this.API_URL}`, formData);
  }

  getRandomCoffee() : Observable<any>{
    return this.http.get(`${this.API_URL}/random`);
  }

  filterCoffees(query: any) {
    return this.http.get(`${this.API_URL}/search?q=${query}`)
  }

  getCoffeeById(id : number) : Observable<any>{
    return this.http.get(`${this.API_URL}/${id}`);
  }

  updateCoffee(id : number, formData: any) {
    return this.http.put(`${this.API_URL}/${id}`, formData);
  }

  deleteCoffee(id : number) : Observable<any>{
    return this.http.delete(`${this.API_URL}/${id}`);
  }

}
