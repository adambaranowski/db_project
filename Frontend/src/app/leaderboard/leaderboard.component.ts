import { Component, OnInit } from '@angular/core';
import { LeaderboardService } from './leaderboard.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent {

  public leaderboard = [] as any;

  constructor(private leaderboardService : LeaderboardService){}

  ngOnInit(){
    this.leaderboardService.getLeaderboard().subscribe(data => this.leaderboard = data);
  }
}
