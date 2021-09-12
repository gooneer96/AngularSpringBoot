import { Observable } from "rxjs";
import { GradeService } from "./../grade.service";
import { Grade } from "./../grade";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: "app-grade-list-by-student",
  templateUrl: "./grade-list-by-student.component.html",
  styleUrls: ["./grade-list-by-student.component.css"]
})
export class GradeListByStudentComponent implements OnInit {
  grades: Observable<Grade[]>
  id: number;
  

  constructor(private route: ActivatedRoute, private gradeService: GradeService,
    private router: Router) { }

  ngOnInit() {    

    this.id = this.route.snapshot.params['id'];
    
    this.reloadData(this.id);
  }

  reloadData(id: number) {
    this.grades = this.gradeService.showGrade(id);
  }

  deleteGrade(id: number) {
    this.gradeService.deleteGrade(id)
      .subscribe(
        data => {
          console.log(data);
          this.gotoStart();
        },
        error => console.log(error));
  }

  gotoStart() {
    this.router.navigate(['']);
  }

  updateGrade(id: number) {
    this.router.navigate(['updategrades', id]);
  }
}
