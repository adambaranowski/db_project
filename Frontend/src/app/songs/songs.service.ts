import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ISongs } from './songs';

@Injectable()
export class SongsService{

    private url : string = "https://g04.labagh.pl/songs/all";
    constructor(private http: HttpClient) {}

    getSongs(): Observable<ISongs[]> {
        return this.http.get<ISongs[]>(this.url);
    }
}
