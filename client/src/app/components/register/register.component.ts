import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  form: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    profilePicture: new FormControl(''),
    bio: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  hide: boolean = true;
  error!: string;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  submit(): void {
    if (this.form.valid) {
      this.userService.register(this.form.value).subscribe(
        {
          next: () => {
            setTimeout(() => {
              this.router.navigate(['/login']);
            }, 1000);
          },
          error: (e) => {
            console.log(e);
            this.error = e.error.message;
          }
        }
      );
    }
  }

}
