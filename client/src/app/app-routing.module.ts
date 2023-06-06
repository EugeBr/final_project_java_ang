import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from './components/home/home.component';
import { CoffeeInfoComponent } from './components/coffee-info/coffee-info.component';
import { NewCoffeeFormComponent } from './components/new-coffee-form/new-coffee-form.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { EditCoffeeFormComponent } from './components/edit-coffee-form/edit-coffee-form.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "register",
    component: RegisterComponent
  },
  {
    path: "profile",
    component: ProfileComponent
  },
  {
    path: "coffees/:id",
    component: CoffeeInfoComponent
  },
  {
    path: "coffees/:id/edit",
    component: EditCoffeeFormComponent
  },
  {
    path: "random",
    component: CoffeeInfoComponent
  },
  {
    path: "new",
    component: NewCoffeeFormComponent
  },
  {
    path: "**",
    component: ErrorPageComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
