import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userId: any = localStorage.getItem("user");
  user!: any;
  coffeeList!: any;
  favList!: any;
  coffeeTab: boolean = true;
  favsTab: boolean = false;
  infoTab: boolean = false;

  constructor(private userService: UserService) { };

  ngOnInit(): void {
    this.getUser();
    this.getCoffees();
  }

  getUser(): void {
    if (this.userId != null) {
      this.userService.getUserById(Number(this.userId)).subscribe(
        {
          next: (data) => {
            this.user = data;
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    }
  }

  getCoffees(): void {
    this.userService.getUserCoffees(Number(this.userId)).subscribe(
      {
        next: (data) => {
          this.coffeeList = data;
        },
        error: (e) => {
          console.log(e);
        }
      }
    );
  }

  //todo GET FAVOURITES

  coffeeActive(): void {
    this.coffeeTab = true;
    this.favsTab = false;
    this.infoTab = false;
  }

  favsActive(): void {
    this.coffeeTab = false;
    this.favsTab = true;
    this.infoTab = false;
  }

  infoActive(): void {
    this.coffeeTab = false;
    this.favsTab = false;
    this.infoTab = true;
  }

}
