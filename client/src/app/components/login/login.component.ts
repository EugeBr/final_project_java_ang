import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  hide: boolean = true;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const isReloading = localStorage.getItem("isReloading");
    if(isReloading) {
      localStorage.removeItem("isReloading");
      this.router.navigate(['/']);
    };
  }

  submit(): void {
    if (this.form.valid) {
      this.userService.login(this.form.value).subscribe(
        {
          next: (data) => {
            //console.log(data);
            localStorage.clear();
            localStorage.setItem("user", data.id);
            localStorage.setItem("isReloading", "true");
            //console.log("LOCAL-STORAGE: ", localStorage.getItem("user"));
            window.location.reload();
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    }
  }

}