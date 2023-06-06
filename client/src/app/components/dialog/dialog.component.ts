import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CoffeeService } from 'src/app/services/coffee.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent {
  constructor(
    private coffeeService: CoffeeService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public dialogRef: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  deleteCoffee(): void {
    console.log(this.data.id);

    this.coffeeService.deleteCoffee(this.data.id).subscribe(
      {
        next: () => {
          console.log("coffee deleted");

          setTimeout(() => {
            this.router.navigate(['/']);
          }, 1000);
        }
      }
    );
  }
}
