package pl.adambaranowski.dbproject.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.adambaranowski.dbproject.model.*;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Service
@NamedNativeQuery(name = "addVote", query = "INSERT INTO votes (song_id, user_id) VALUES (?, ?);")
@NamedNativeQuery(name = "deleteVoteById", query = "DELETE FROM votes WHERE vote_id=?;")
@NamedNativeQuery(name = "getVotesForSongId", query = "SELECT * FROM  votes WHERE song_id=?;")
@NamedNativeQuery(name = "getVotesForUserId", query = "SELECT * FROM votes WHERE user_id=?;")
@NamedNativeQuery(name = "getAllVotes", query = "SELECT * FROM votes;")
public class VoteService {

    private static final String ADD_VOTE = "INSERT INTO votes (song_id, user_id) VALUES (?, ?);";
    private static final String DELETE_VOTE_BY_ID = "DELETE FROM votes WHERE vote_id=?;";
    private static final String GET_VOTES_FOR_SONG_ID = "SELECT * FROM  votes WHERE song_id=?;";
    private static final String GET_USER_BY_USER_ID = "SELECT * FROM votes WHERE user_id=?;";
    private static final String GET_ALL_VOTES = "SELECT * FROM votes;";

    private JdbcTemplate template;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Vote.class);

    @Autowired
    public VoteService(JdbcTemplate template) {
        this.template = template;
    }

    public void addVote(int song_id, int user_id){
        template.update(ADD_VOTE, song_id, user_id);
    }

    public void deleteVoteById(int vote_id){
        template.update(DELETE_VOTE_BY_ID, vote_id);
    }

    public List<Vote> getVotesForSongId(int song_id){
        List<Vote> query = template.query(GET_VOTES_FOR_SONG_ID, rowMapper, song_id);
        return query;
    }


    public List<Vote>  getVotesForUserId(int user_id){
        List<Vote> query = template.query(GET_USER_BY_USER_ID, rowMapper, user_id);
        return query;
    }


    public List<Vote> getAllVotes(){
        List<Vote> query = template.query(GET_ALL_VOTES, rowMapper);
        return query;
    }

}
