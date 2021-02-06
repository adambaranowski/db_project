import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MainComponent } from './main/main.component';
import { AlbumsComponent } from './albums/albums.component';
import { SongsComponent } from './songs/songs.component';
import { UsersComponent } from './users/users.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { VoteComponent } from './vote/vote.component';
import { AlbumspopComponent } from './albumspop/albumspop.component';
import { HttpClientModule } from '@angular/common/http';
import { AlbumsService } from './albums/albums.service';
import { AlbumspopService } from './albumspop/albumspop.service';
import { LeaderboardService } from './leaderboard/leaderboard.service';
import { SongsService } from './songs/songs.service';
import { UsersService } from './users/users.service';
import { VoteService } from './vote/vote.service';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MainComponent,
    AlbumsComponent,
    SongsComponent,
    UsersComponent,
    LeaderboardComponent,
    VoteComponent,
    AlbumspopComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AlbumsService, AlbumspopService, LeaderboardService, SongsService, UsersService, VoteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
