import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  userId: any = localStorage.getItem("user");
  user!: any;
  isLoggedIn: boolean = false;

  constructor(private userService: UserService) { };

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    if (this.userId != null) {
      this.userService.getUserById(Number(this.userId)).subscribe(
        {
          next: (data) => {
            this.user = data;
            this.isLoggedIn = true;
            //console.log(data);
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    }
  }

  logout(): void {
    localStorage.removeItem("user");
    window.location.reload();
  }

}
