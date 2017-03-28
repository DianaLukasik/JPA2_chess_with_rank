package com.capgemini.chess.dao;

import java.util.List;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public interface GameDao extends Dao<GameEntity, Long> {

	List<GameEntity> getAllGamesForUser(Long id);

	List<GameEntity> findGameWithCriteriaBuilder(Integer winnerPoints, Integer loserPoints, UserEntity winner,
			UserEntity loser);

}
