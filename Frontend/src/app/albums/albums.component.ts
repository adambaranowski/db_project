import { Component, OnInit } from '@angular/core';
import { AlbumsService } from './albums.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent {

  album_name : string = "-";
  author : string = "-";
  id : number = 0;

  public albums = [] as any;

  constructor(private albumsService : AlbumsService, private http : HttpClient){}

  ngOnInit(){
    this.albumsService.getAlbums().subscribe(data => this.albums = data);
  }

  postData(){

    let url = "http://localhost:7400/albums?album_name=cipa&category_id=1";

    this.http.post(url, {category_id : 1, album_name : "cipa"}).toPromise().then((data : any) => {
      console.log(data)
      console.log(JSON.stringify(data.json.album_name, data.json.autor, data.json.id))
    })
  }
}