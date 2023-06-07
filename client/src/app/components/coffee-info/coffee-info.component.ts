import { Component, OnInit } from '@angular/core';
import { CoffeeService } from 'src/app/services/coffee.service';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-coffee-info',
  templateUrl: './coffee-info.component.html',
  styleUrls: ['./coffee-info.component.css']
})
export class CoffeeInfoComponent implements OnInit {

  coffee!: any;
  id: number = this.activatedRoute.snapshot.params["id"];
  isOwner: boolean = false;
  userId = localStorage.getItem("user");

  constructor(
    private coffeeService: CoffeeService,
    private activatedRoute: ActivatedRoute,
    public dialog: MatDialog
  ) { };

  ngOnInit(): void {
    this.getCoffee();
  }

  getCoffee(): void {

    let url = document.location.href;
    let urlArray = url.split('/');
    let endPoint = urlArray[urlArray.length - 1];

    if (endPoint === "random") {
      this.coffeeService.getRandomCoffee().subscribe(
        {
          next: (data) => {
            this.coffee = data;
            if (this.userId == data.createdBy.id) this.isOwner = true;
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    } else if (endPoint === this.id.toString()) {
      this.coffeeService.getCoffeeById(this.id).subscribe(
        {
          next: (data) => {
            this.coffee = data;
            if (this.userId == data.createdBy.id) this.isOwner = true;
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    }
    
  }

  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(DialogComponent, {
      width: '250px',
      enterAnimationDuration,
      exitAnimationDuration,
      data: {
        id: this.id
      }
    });
  }

}
