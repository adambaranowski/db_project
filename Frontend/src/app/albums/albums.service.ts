import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IAlbums } from './albums';

@Injectable()
export class AlbumsService{

    private url : string = "http://localhost:7400/albums/all";
    constructor(private http: HttpClient) {}

    getAlbums(): Observable<IAlbums[]> {
        return this.http.get<IAlbums[]>(this.url);
    }
}
