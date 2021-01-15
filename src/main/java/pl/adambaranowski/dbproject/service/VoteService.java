package pl.adambaranowski.dbproject.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.*;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import java.util.List;

@Service
@NamedNativeQuery(name = "addVote", query = "INSERT INTO votes (song_id, user_id) VALUES ?, ?;")
@NamedNativeQuery(name = "deleteVoteById", query = "DELETE FROM votes WHERE vote_id=?;")
@NamedNativeQuery(name = "getVotesForSongId", query = "SELECT FROM  votes WHERE song_id=?;")
@NamedNativeQuery(name = "getVotesForUserId", query = "SELECT FROM votes WHERE user_id=?;")
@NamedNativeQuery(name = "getAllVotes", query = "SELECT * FROM votes;")
public class VoteService {

    private EntityManager entityManager;

    @Autowired
    public VoteService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addVote(int song_id, int user_id){
        Query query = entityManager.createNativeQuery("addVote");
        query.setParameter(1, song_id);
        query.setParameter(2, user_id);
        query.executeUpdate();
    }

    public void deleteVoteById(int vote_id){
        Query query = entityManager.createNativeQuery("deleteVoteById");
        query.setParameter(1, vote_id);
        query.executeUpdate();
    }

    public List<Vote> getVotesForSongId(int song_id){
        Query query = entityManager.createNativeQuery("getVotesForSongId", Vote.class);
        query.setParameter(1, song_id);
        List<Vote> resultList = query.getResultList();
        return resultList;
    }


    public List<Vote>  getVotesForUserId(int user_id){
        Query query = entityManager.createNativeQuery("getVotesForUserId", Vote.class);
        query.setParameter(1, user_id);
        List<Vote> resultList = query.getResultList();
        return resultList;
    }


    public List<Vote> getAllVotes(){
        Query query = entityManager.createNativeQuery("getAllVotes", Vote.class);
        List<Vote> resultList = query.getResultList();
        return resultList;
    }

}
