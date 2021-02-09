import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUsers } from './users';

@Injectable()
export class UsersService{

    private url : string = "http://localhost:7400/users/all";
    constructor(private http: HttpClient) {}

    getUsers(): Observable<IUsers[]> {
        return this.http.get<IUsers[]>(this.url);
    }
}
