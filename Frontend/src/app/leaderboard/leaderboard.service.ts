import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ILeaderboard } from './leaderboard';

@Injectable()
export class LeaderboardService{

    private url : string = "http://localhost:7400/leaderboard/all";
    constructor(private http: HttpClient) {}

    getLeaderboard(): Observable<ILeaderboard[]> {
        return this.http.get<ILeaderboard[]>(this.url);
    }
}
