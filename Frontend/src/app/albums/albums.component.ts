import { Component, OnInit, NgModule } from '@angular/core';
import { AlbumsService } from './albums.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent {

  album_name : string = "";
  author : string = "-";

  public albums = [] as any;

  constructor(
    private albumsService : AlbumsService, 
    private http : HttpClient,
    ) {}

  ngOnInit() {
    this.albumsService.getAlbums().subscribe(data => this.albums = data);
  }

  createAlbum() {
    console.log(this.album_name);
    let url = `https://g04.labagh.pl/albums?album_name=${this.album_name}`;

    this.http.post(url, {album_name : this.album_name}).toPromise().then((data : any) => {
      console.log(data);
      window.location.reload();
    })
  }
}