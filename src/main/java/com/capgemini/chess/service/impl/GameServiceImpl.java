package com.capgemini.chess.service.impl;

import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.dao.GameDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.mapper.GameMapper;
import com.capgemini.chess.service.GameService;
import com.capgemini.chess.service.to.GameTO;

@Service
@Transactional
public class GameServiceImpl extends AbstractService<GameEntity, Long> implements GameService {

	@Autowired
	UserDao userDao;
	@Autowired
	GameDao gameDao;

	@Override
	public void updatePlayerPoints() {
		for (UserEntity user : userDao.findAll()) {
			for (GameEntity game : gameDao.getAllGamesForUser(user.getId())) {
				if (game.getWinner().equals(user.getId())) {
					user.addPoints(game.getWinnerPoints());
				} else {
					user.addPoints(game.getLoserPoints());
				}
			}
		}
	}

	@Override
	public void updatePlayersGameHistory() {
		for (GameEntity game : gameDao.findAll()) {
			UserEntity winner = game.getWinner();
			UserEntity loser = game.getLoser();
			Set<GameEntity> winnerSet = winner.getGameSet();
			Set<GameEntity> loserSet = loser.getGameSet();
			winnerSet.add(game);
			loserSet.add(game);
			winner.setGameSet(winnerSet);
			loser.setGameSet(loserSet);
		}
	}

	@Override
	public void addNewGame(GameTO game) {
		GameEntity gameEntity = GameMapper.map(game);
		gameEntity.setWinner(userDao.findOne(game.getWinner().getId()));
		gameEntity.setLoser(userDao.findOne(game.getLoser().getId()));
		gameDao.save(gameEntity);
	}

	@Override
	public Set<GameEntity> getGameSetForUser(Long id) {
		return userDao.findOne(id).getGameSet();
	}
}
