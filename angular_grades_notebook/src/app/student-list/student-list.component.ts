import { Observable } from "rxjs";
import { StudentService } from "./../student.service";
import { Student } from "./../student";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';


@Component({
  selector: "app-student-list",
  templateUrl: "./student-list.component.html",
  styleUrls: ["./student-list.component.css"]
})
export class StudentListComponent implements OnInit {
  students: Observable<Student[]>;

  
  
  constructor(private studentService: StudentService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.students = this.studentService.getStudentsList();
  }

 

  deleteStudent(id: number) {
    this.studentService.deleteStudent(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  showGrades(id: number) {
    this.router.navigate(['studentgrades', id]);
  }

  updateStudent(id: number) {
    this.router.navigate(['updatestudent', id]);
  }
}
