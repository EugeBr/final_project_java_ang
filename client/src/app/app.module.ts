import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './components/menu/menu.component';
import { CoffeeListComponent } from './components/coffee-list/coffee-list.component';
import { NewCoffeeFormComponent } from './components/new-coffee-form/new-coffee-form.component';
import { CoffeeInfoComponent } from './components/coffee-info/coffee-info.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { HomeComponent } from './components/home/home.component';
import { SearchBarComponent } from './components/search-bar/search-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    CoffeeListComponent,
    NewCoffeeFormComponent,
    CoffeeInfoComponent,
    ErrorPageComponent,
    HomeComponent,
    SearchBarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
