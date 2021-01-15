DELIMITER //

CREATE PROCEDURE top_n_songs(n INTEGER)
BEGIN
SELECT s.title as 'TITLE', author_name as 'AUTHOR', c.name as 'CATEGORY', num_votes AS 'NUM_VOTES'
	FROM songs s 
		INNER JOIN albums a ON a.album_id=s.album_id  
		INNER JOIN categories c ON c.category_id=a.category_id
		INNER JOIN authors auth ON auth.author_id=s.author_id
		INNER JOIN (
			SELECT song_id, count(song_id) as num_votes 
			FROM votes GROUP BY song_id 
		) v ON v.song_id=s.song_id
	ORDER BY 'NUM_VOTES' DESC
	LIMIT n;
END; //

DELIMITER ;
