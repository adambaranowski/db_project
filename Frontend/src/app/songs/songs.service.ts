import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ISongs } from './songs';

@Injectable()
export class SongsService{

    private url : string = "http://localhost:7400/songs/all";
    constructor(private http: HttpClient) {}

    getSongs(): Observable<ISongs[]> {
        return this.http.get<ISongs[]>(this.url);
    }
}
