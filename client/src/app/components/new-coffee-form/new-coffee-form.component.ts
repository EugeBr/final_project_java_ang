import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators, FormArray, FormBuilder  } from '@angular/forms';

@Component({
  selector: 'app-new-coffee-form',
  templateUrl: './new-coffee-form.component.html',
  styleUrls: ['./new-coffee-form.component.css']
})
export class NewCoffeeFormComponent {

  registerForm: FormGroup;
  nameInput: FormControl;
  categoryInput: FormControl;
  imageUrl: string;
  descriptionInput: FormControl;
  prepTimeInput: FormControl;
  ingredientsInput: FormArray;
  instructionsInput: FormArray;
  newIngredient: string;
  newIstruction: string;
  notesInput: FormControl;

  constructor(private fb:FormBuilder) {

    this.nameInput = new FormControl('', Validators.required);
    this.categoryInput = new FormControl('', Validators.required);
    this.imageUrl = '';
    this.descriptionInput = new FormControl('', [Validators.required, Validators.maxLength(300)]);
    this.prepTimeInput = new FormControl('', Validators.required);
    this.ingredientsInput = this.fb.array([]);
    this.instructionsInput = this.fb.array([]);
    this.newIngredient = '';
    this.newIstruction = '';
    this.notesInput = new FormControl('', [Validators.required, Validators.maxLength(150)]);

    this.registerForm = new FormGroup({
      name: this.nameInput,
      category: this.categoryInput,
      description: this.descriptionInput,
      prepTime: this.prepTimeInput,
      notes: this.notesInput
    });
  }

  onSubmit(): void {
    console.log('Coffee created...'); 
    this.registerForm.reset();
  }

  addIngredient(){
    this.ingredientsInput.push(this.newIngredient);
  }
}
