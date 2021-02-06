import { Component, OnInit } from '@angular/core';
import { AlbumspopService } from './albumspop.service';

@Component({
  selector: 'app-albumspop',
  templateUrl: './albumspop.component.html',
  styleUrls: ['./albumspop.component.css']
})
export class AlbumspopComponent {

  public albumspop = [] as any;

  constructor(private albumspopService : AlbumspopService){}

  ngOnInit(){
    this.albumspopService.getAlbumspop().subscribe(data => this.albumspop = data);
  }

}
