import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUsers } from './users';

@Injectable()
export class UsersService{

    private url : string = "https://g04.labagh.pl/users/all";
    constructor(private http: HttpClient) {}

    getUsers(): Observable<IUsers[]> {
        return this.http.get<IUsers[]>(this.url);
    }
}
