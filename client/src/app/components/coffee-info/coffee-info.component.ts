import { Component, OnInit } from '@angular/core';
import { CoffeeService } from 'src/app/services/coffee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-coffee-info',
  templateUrl: './coffee-info.component.html',
  styleUrls: ['./coffee-info.component.css']
})
export class CoffeeInfoComponent implements OnInit {

  coffee!: any;

  constructor(
    private coffeeService: CoffeeService,
    private activatedRoute: ActivatedRoute,
  ) { };

  ngOnInit(): void {
    this.getCoffee();
  }

  getCoffee(): void {
    const id = this.activatedRoute.snapshot.params["id"];

    this.coffeeService.getCoffeeById(id).subscribe(
      {
        next: (data) => {
          this.coffee = data;
          console.log(data);

        },
        error: (e) => {
          console.log(e);
        }
      }
    );
  }
}
