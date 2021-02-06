import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './main/main.component';
import { AlbumsComponent } from './albums/albums.component';
import { SongsComponent } from './songs/songs.component';
import { UsersComponent } from './users/users.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { VoteComponent } from './vote/vote.component';
import { AlbumspopComponent } from './albumspop/albumspop.component';

const routes: Routes = [
  {path: '', component: MainComponent},
  {path: 'albums', component: AlbumsComponent},
  {path: 'songs', component: SongsComponent},
  {path: 'users', component: UsersComponent},
  {path: 'leaderboard', component: LeaderboardComponent},
  {path: 'albumspop', component: AlbumspopComponent},
  {path: 'vote', component: VoteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
