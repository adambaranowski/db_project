import { Component, OnInit } from '@angular/core';
import { UsersService } from './users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  public users = [] as any;

  constructor(private usersService : UsersService){}

  ngOnInit(){
    this.usersService.getUsers().subscribe(data => this.users = data);
  }
}
