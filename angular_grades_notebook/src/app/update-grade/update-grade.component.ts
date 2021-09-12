import { Component, OnInit } from '@angular/core';
import { Grade } from '../grade';
import { ActivatedRoute, Router } from '@angular/router';
import { GradeService } from '../grade.service';

@Component({
  selector: 'app-update-grade',
  templateUrl: './update-grade.component.html',
  styleUrls: ['./update-grade.component.css']
})
export class UpdateGradeComponent implements OnInit {

  id: number;
  grade: Grade;

  constructor(private route: ActivatedRoute, private router: Router,
    private gradeService: GradeService) { }

  ngOnInit() {
    this.grade = new Grade();

    this.id = this.route.snapshot.params['id'];

    this.gradeService.getGrade(this.id)
      .subscribe(data => {
        console.log(data)
        this.grade = data;
      }, error => console.log(error));
  }

  updategrade() {
    this.gradeService.updateGrade(this.id, this.grade)
      .subscribe(data => {
        console.log(data);
        this.grade = new Grade();
        this.gotoStart();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updategrade();
  }

  gotoStart() {
    this.router.navigate(['']);
  }
}
