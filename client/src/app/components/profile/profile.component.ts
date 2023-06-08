import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
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
  hide: boolean = true;
  usernameInput: FormControl;
  profilePictureInput: FormControl;
  bioInput: FormControl;
  passwordInput: FormControl;
  form: FormGroup;

  constructor(private userService: UserService) {
    this.usernameInput = new FormControl('', Validators.required);
    this.profilePictureInput = new FormControl('');
    this.bioInput = new FormControl('', Validators.required);
    this.passwordInput = new FormControl('', Validators.required);


    this.form = new FormGroup({
      username: this.usernameInput,
      profilePicture: this.profilePictureInput,
      bio: this.bioInput,
      password: this.passwordInput
    });
  };

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
            this.usernameInput.setValue(data.username);
            this.profilePictureInput.setValue(data.profilePicture);
            this.bioInput.setValue(data.bio);
            this.passwordInput.setValue(data.password);
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

  submit(): void {
    if (this.form.valid) {
      this.userService.updateUser(this.userId, this.form.value).subscribe(
        {
          next: () => {
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
