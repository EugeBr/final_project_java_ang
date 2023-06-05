import { Component, OnInit } from '@angular/core';
import { CoffeeService } from 'src/app/services/coffee.service';

@Component({
  selector: 'app-coffee-list',
  templateUrl: './coffee-list.component.html',
  styleUrls: ['./coffee-list.component.css']
})
export class CoffeeListComponent implements OnInit {

  coffeeList!: any;
  hotCoffeeList!: any[];
  coldCoffeeList!: any[];
  query!: string;

  constructor(
    private coffeeService: CoffeeService,
  ) { };

  ngOnInit(): void {
    this.getCoffees();
  }

  getCoffees(): void {
    this.coffeeService.getCoffees().subscribe(
      {
        next: (data) => {
          this.hotCoffeeList = [];
          this.coldCoffeeList = [];
          for (let index = 0; index < data.length; index++) {
            const item = data[index];
            if (item.category === "HOT") {
              this.hotCoffeeList.push(item);
            } else {
              this.coldCoffeeList.push(item);
            }
          }
        },
        error: (e) => {
          console.log(e);
        }
      }
    );
  }

  searchCoffees(): void {
    this.coffeeService.filterCoffees(this.query).subscribe(
      {
        next: (filteredData) => {
          this.coffeeList = filteredData;
        },
        error: (e) => {
          console.log(e);

        }
      }
    );
  }

}
