import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-coffee-card',
  templateUrl: './coffee-card.component.html',
  styleUrls: ['./coffee-card.component.css']
})
export class CoffeeCardComponent {

  @Input("coffeeProp")
  coffee!: any; 

  @Input()
  index: number;

  constructor() {
    this.index = 0;
  }
}
