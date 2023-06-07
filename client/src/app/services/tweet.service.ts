import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TweetService {

  private readonly API_URL = "http://localhost:8083/api/tweets";

  constructor(private http: HttpClient) { }

  getTweets() : Observable<any>{
    return this.http.get(`${this.API_URL}`);
  }
}
