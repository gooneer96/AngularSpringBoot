import { Component, OnInit } from '@angular/core';
import { GradeService } from '../grade.service';
import { Grade } from '../grade';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-grade',
  templateUrl: './add-grade.component.html',
  styleUrls: ['./add-grade.component.css']
})
export class AddGradeComponent implements OnInit {

  grade: Grade = new Grade();
  submitted = false;

  constructor(private gradeService: GradeService,
    private router: Router) { }

  ngOnInit() {
  }

  newGrade(): void {
    this.submitted = false;
    this.grade = new Grade();
  }

  save() {
    this.gradeService
      .addGrade(this.grade).subscribe(data => {
        console.log(data)
        this.grade = new Grade();
        this.gotoStart();
      },
        error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoStart() {
    this.router.navigate(['']);
  }
}
