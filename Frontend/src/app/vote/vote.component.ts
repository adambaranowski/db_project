import { Component, OnInit } from '@angular/core';
import { VoteService } from './vote.service';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css']
})
export class VoteComponent {

  public vote = [] as any;

  constructor(private voteService : VoteService){}

  ngOnInit(){
    this.voteService.getVote().subscribe(data => this.vote = data);
  }
}
