package com.capgemini.chess.service;

import java.util.Set;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.service.to.GameTO;

public interface GameService {
	void updatePlayerPoints();

	void addNewGame(GameTO game);

	void updatePlayersGameHistory();

	Set<GameEntity> getGameSetForUser(Long id);

}
