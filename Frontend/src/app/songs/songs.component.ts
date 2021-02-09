import { Component, OnInit } from '@angular/core';
import { SongsService } from './songs.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-songs',
  templateUrl: './songs.component.html',
  styleUrls: ['./songs.component.css']
})
export class SongsComponent {

  title : string = "-";
  album_name : string = "-";
  author : string = "-";
  username : string = "-";
  id : number = 0;

  public songs = [] as any;

  constructor(private songsService : SongsService, private http : HttpClient){}

  ngOnInit(){
    this.songsService.getSongs().subscribe(data => this.songs = data);
  }

  createSong(){
    console.log(this.title);
    let url = `http://localhost:7400/songs?title=${this.title}`;

    this.http.post(url, {title : this.title, author : this.author, username : this.username}).toPromise().then((data : any) => {
      console.log(data);
      window.location.reload();
    })
  }

  postData(){
    console.log('asda');
  }
}
