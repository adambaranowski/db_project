import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IAlbumspop } from './albumspop';

@Injectable()
export class AlbumspopService{

    private url : string = "https://g04.labagh.pl/albums/all";
    constructor(private http: HttpClient) {}

    getAlbumspop(): Observable<IAlbumspop[]> {
        return this.http.get<IAlbumspop[]>(this.url);
    }
}
