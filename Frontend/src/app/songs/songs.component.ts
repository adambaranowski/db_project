import { Component, OnInit } from '@angular/core';
import { SongsService } from './songs.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-songs',
  templateUrl: './songs.component.html',
  styleUrls: ['./songs.component.css']
})
export class SongsComponent {

  album_name : string = "-";
  author : string = "-";
  id : number = 0;

  public songs = [] as any;

  constructor(private songsService : SongsService, private http : HttpClient){}

  ngOnInit(){
    this.songsService.getSongs().subscribe(data => this.songs = data);
  }

  postData(){

    let url = "http://localhost:7400/songs";

    this.http.post(url, {params: {song_name : "lala", album_name : "cipa", author : "krawczyk", song_id : 1}}).toPromise().then((data : any) => {
      console.log(data)
      console.log(JSON.stringify(data.json.album_name, data.json.autor, data.json.id))
    })
  }
}
