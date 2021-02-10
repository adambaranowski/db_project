import { Component, OnInit } from '@angular/core';
import { VoteService } from './vote.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css']
})
export class VoteComponent {

  public vote = [] as any;
  username: string = '';

  constructor(private voteService : VoteService, private http : HttpClient){}

  ngOnInit() {
    this.voteService.getVote().subscribe(data => this.vote = data);
  }

  triggerVote() {
    console.log(this.username);

    if (this.username === '') {
      return;
    }

    var userId: number = 20;

    // check if user exists in database, if not -> create new one with given username
    this.http.get<User[]>('https://g04.labagh.pl/users/all', {}).toPromise().then((data : any) => {
      var exists: boolean = false;
      

      for (var i= 0; i<data.length; i++) {
        if (data[i].username === this.username) {
          exists = true;
          userId = data[i].user_id;
          console.log('EXISTS');
          console.log(data[i]);
          break;    
        }
      }
        
      if (!exists) {
        this.http.post(`https://g04.labagh.pl/users?username=${this.username}`, {}).toPromise().then((data : any) => {
          this.http.get<User[]>('https://g04.labagh.pl/users/all').toPromise().then((usersData: any) => {
            for (var i= 0; i<usersData.length; i++) {
              if (usersData[i].username === this.username) {
                console.log(usersData[i]);
                exists = true;
                userId = usersData[i].user_id;
                break;    
              }
            }

            this.http.get<User[]>('https://g04.labagh.pl/users/all', {}).toPromise().then((allData : any) => {
              for (var i= 0; i<allData.length; i++) {
                if (allData[i].username === this.username) {
                  let url = `https://g04.labagh.pl/vote?user_id=${allData[i].user_id}&song_id=1`;
                  this.http.post(url, {}).toPromise().then((data : any) => {
                    console.log(data);
                    window.location.reload();
                  })
                  break;    
                }
              }
            })
          })
        })
      }
    })
  }
}

interface User {
  user_id: number,
  username: string,
  email: any,
  password_hash: any,
  create_time: string,
}
