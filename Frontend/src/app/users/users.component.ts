import { Component, OnInit } from '@angular/core';
import { UsersService } from './users.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  username : string = "";
  title : string = "-";

  public users = [] as any;

  constructor(private usersService : UsersService, private http : HttpClient){}

  ngOnInit(){
    this.usersService.getUsers().subscribe(data => this.users = data);
  }

  postData() {
    console.log('asda');
  }
}
