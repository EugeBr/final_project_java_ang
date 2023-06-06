import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatChipInputEvent, MatChipEditedEvent } from '@angular/material/chips';
import { CoffeeService } from 'src/app/services/coffee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-new-coffee-form',
  templateUrl: './new-coffee-form.component.html',
  styleUrls: ['./new-coffee-form.component.css']
})
export class NewCoffeeFormComponent {
  coffeeCreated: boolean = false;
  coffeeNotCreated: boolean = false;

  registerForm: FormGroup;
  nameInput: FormControl;
  categoryInput: FormControl;
  imageUrlInput: FormControl;
  descriptionInput: FormControl;
  prepTimeInput: FormControl;
  ingredientsInput: string[] = [];
  ingredientsArray: FormControl;
  ingredient!: string;
  instructionsInput: string[] = [];
  instructionsArray: FormControl;
  istruction!: string;
  notesInput: FormControl;
  user: FormControl;
  userId = localStorage.getItem("user");

  addOnBlur = true;
  readonly separatorKeysCodes = [ENTER, COMMA] as const;

  constructor(
    private coffeeService: CoffeeService,
    private router: Router
    ) {

    this.nameInput = new FormControl('', Validators.required);
    this.categoryInput = new FormControl('', Validators.required);
    this.imageUrlInput = new FormControl('');
    this.descriptionInput = new FormControl('', [Validators.required, Validators.maxLength(300)]);
    this.prepTimeInput = new FormControl('', Validators.required);
    this.ingredientsArray = new FormControl(this.ingredientsInput, Validators.required);
    this.instructionsArray = new FormControl(this.instructionsInput, Validators.required);
    this.notesInput = new FormControl('', [Validators.required, Validators.maxLength(150)]);
    this.user = new FormControl({
      id: this.userId
    })

    this.registerForm = new FormGroup({
      name: this.nameInput,
      category: this.categoryInput,
      imageUrl: this.imageUrlInput,
      description: this.descriptionInput,
      prepTime: this.prepTimeInput,
      ingredients: this.ingredientsArray,
      instructions: this.instructionsArray,
      notes: this.notesInput,
      createdBy: this.user
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      this.coffeeService.createCoffee(this.registerForm.value).subscribe(
        {
          next: (data) => {
            console.log(data);
            this.coffeeCreated = true;
            this.registerForm.reset();
            setTimeout(() => {
              this.router.navigate(['/']);
            }, 1000);
          },
          error: (e) => {
            console.log(e);
            this.coffeeNotCreated = true;
          }
        }
      );
    }
  }

  // Ingredients chips

  addIng(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();
    if (value) {
      this.ingredientsInput.push(value);
    }
    event.chipInput!.clear();
  }

  removeIng(ingredient: string): void {
    const index = this.ingredientsInput.indexOf(ingredient);
    if (index >= 0) {
      this.ingredientsInput.splice(index, 1);
    }
  }

  editIng(ingredient: string, event: MatChipEditedEvent) {
    const value = event.value.trim();
    if (!value) {
      this.removeIng(ingredient);
      return;
    }
    const index = this.ingredientsInput.indexOf(ingredient);
    if (index >= 0) {
      this.ingredientsInput[index] = value;
    }
  }

  // Instructions chips

  addInst(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();
    if (value) {
      this.instructionsInput.push(value);
    }
    event.chipInput!.clear();
  }

  removeInst(instruction: string): void {
    const index = this.instructionsInput.indexOf(instruction);
    if (index >= 0) {
      this.instructionsInput.splice(index, 1);
    }
  }

  editInst(instruction: string, event: MatChipEditedEvent) {
    const value = event.value.trim();
    if (!value) {
      this.removeIng(instruction);
      return;
    }
    const index = this.instructionsInput.indexOf(instruction);
    if (index >= 0) {
      this.instructionsInput[index] = value;
    }
  }
}
