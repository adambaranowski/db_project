import { Component, OnInit, NgModule } from '@angular/core';
import { AlbumsService } from './albums.service';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent {

  album_name : string = "";
  author : string = "-";

  // createAlbumForm = this.formBuilder.group({
  // // createAlbumForm = new FormGroup({
  //   name: '',
  // })

  public albums = [] as any;

  constructor(
    private albumsService : AlbumsService, 
    private http : HttpClient,
    // private formBuilder: FormBuilder,
    ) {}

  ngOnInit() {
    this.albumsService.getAlbums().subscribe(data => this.albums = data);
  }

  createAlbum() {
    console.log(this.album_name);
    let url = `http://localhost:7400/albums?album_name=${this.album_name}`;

    this.http.post(url, {album_name : this.album_name}).toPromise().then((data : any) => {
      console.log(data);
      window.location.reload();
    })
  }

  postData() {

    // console.log(this.createAlbumForm.value);
    console.log('asda');

    // this.http.post(url, {category_id : 1, album_name : "albumasda"}).toPromise().then((data : any) => {
    //   console.log(data)
    //   console.log(JSON.stringify(data.json.album_name, data.json.autor, data.json.id))
    // })
  }
}