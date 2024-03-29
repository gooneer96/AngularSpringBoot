import { Observable } from "rxjs";
import { UserService } from "./../user.service";
import { User } from "./../user";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-user-list",
  templateUrl: "./user-list.component.html",
  styleUrls: ["./user-list.component.css"]
})
export class UserListComponent implements OnInit {
  users: Observable<User[]>;

  constructor(private userService: UserService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.getusersList();
  }

  deleteUser(id: number) {
    this.userService.deleteuser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  userDetails(id: number){
    this.router.navigate(['detailsuser', id]);
  }

  updateUser(id: number){
    this.router.navigate(['updateuser', id]);
  }
}
