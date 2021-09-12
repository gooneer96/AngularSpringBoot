import { CreateUserComponent } from './create-user/create-user.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { StudentListComponent } from './student-list/student-list.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { AddGradeComponent } from './add-grade/add-grade.component';
import { UpdateGradeComponent } from './update-grade/update-grade.component';
import { GradeListByStudentComponent } from './grade-list-by-student/grade-list-by-student.component';


const routes: Routes = [
  { path: '', redirectTo: 'user', pathMatch: 'full' },
  { path: 'users', component: UserListComponent },
  { path: 'addusers', component: CreateUserComponent },
  { path: 'updateuser/:id', component: UpdateUserComponent },
  { path: 'students', component: StudentListComponent },
  { path: 'addstudents', component: CreateStudentComponent },
  { path: 'updatestudent/:id', component: UpdateStudentComponent },
  { path: 'grades', component: AddGradeComponent },
  { path: 'updategrades/:id', component: UpdateGradeComponent },
  { path: 'studentgrades/:id', component: GradeListByStudentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
