import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private userService: UserService) { }

  hide = true;

  submit() {
    if (this.form.valid) {
     // console.log(this.form.value);
      this.userService.login(this.form.value).subscribe(
        {
          next: (data) => {
            console.log(data);
            localStorage.clear();
            localStorage.setItem("user", data.id);
            console.log("LOCAL-STORAGE: ", localStorage.getItem("user"));
          },
          error: (e) => {
            console.log(e);
          }
        }
      );
    }
  }
}