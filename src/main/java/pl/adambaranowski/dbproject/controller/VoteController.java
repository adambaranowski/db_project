package pl.adambaranowski.dbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.dbproject.model.Vote;
import pl.adambaranowski.dbproject.service.VoteService;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity addNewVote(@RequestParam Integer song_id, @RequestParam Integer user_id){
        voteService.addVote(song_id, user_id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vote>> getAllVotes(){
        List<Vote> allVotes = voteService.getAllVotes();
        return new ResponseEntity<>(allVotes, HttpStatus.OK);
    }

    @GetMapping("/song-id/{song_id}")
    public ResponseEntity<List<Vote>> getVotesForSongId(@PathVariable Integer song_id){
        List<Vote> votesForSongId = voteService.getVotesForSongId(song_id);
        return new ResponseEntity<>(votesForSongId, HttpStatus.OK);
    }

    @GetMapping("/user-id/{user_id}")
    public ResponseEntity<List<Vote>> getVotesForUserId(@PathVariable Integer user_id){
        List<Vote> votesForUserId = voteService.getVotesForUserId(user_id);
        return new ResponseEntity<>(votesForUserId, HttpStatus.OK);
    }

    @DeleteMapping("/vote-id/{vote_id}")
    public ResponseEntity<Object> deleteVoteForId(@PathVariable Integer vote_id){
        voteService.deleteVoteById(vote_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
