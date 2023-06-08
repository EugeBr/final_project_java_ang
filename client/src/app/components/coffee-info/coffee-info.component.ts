import { Component, OnInit } from '@angular/core';
import { CoffeeService } from 'src/app/services/coffee.service';
import { ActivatedRoute } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

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
  isFav: boolean = false;

  constructor(
    private coffeeService: CoffeeService,
    private activatedRoute: ActivatedRoute,
    public dialog: MatDialog,
    private userService: UserService,
    private router: Router
  ) { };

  ngOnInit(): void {
    this.getCoffee();
    this.getUserFav();
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

  getUserFav(): void {
    if (this.userId != null) {
      this.userService.getUserById(Number(this.userId)).subscribe(
        {
          next: (data) => {
            const favListIds: number[] = [];
            data.favList.forEach((fav: any) => {
              favListIds.push(Number(fav.id));
            });
            if (favListIds.includes(Number(this.id))) {
              this.isFav = true;
            }
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    }
  }


  like(): void {
    if (this.userId != null) {
      this.isFav = true;
      this.userService.addFav(this.id, Number(this.userId)).subscribe(
        {
          next: () => {
            console.log("fav added");
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    } else {
      this.router.navigate(['/login']);
    }
  }

  unlike(): void {
    this.isFav = false;
    this.userService.removeFav(this.id, Number(this.userId)).subscribe(
      {
        next: () => {
          console.log("fav removed");
        },
        error: (e) => {
          console.log(e);
        }
      }
    );
  }

}
