import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IVote } from './vote';

@Injectable()
export class VoteService{

    private url : string = "http://localhost:7400/songs/all";
    constructor(private http: HttpClient) {}

    getVote(): Observable<IVote[]> {
        return this.http.get<IVote[]>(this.url);
    }
}
