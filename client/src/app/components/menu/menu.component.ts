import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  userId: any = localStorage.getItem("user");
  user!: any;
  isLoggedIn: boolean = false;

  constructor(
    private userService: UserService,
    private router: Router
    ) { };

  ngOnInit(): void {
    this.getUser();
    const isReloading = localStorage.getItem("isReloading");
    if(isReloading) {
      localStorage.removeItem("isReloading");
      this.router.navigate(['/']);
    };
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
    localStorage.setItem("isReloading", "true");
    window.location.reload();
  }

}
