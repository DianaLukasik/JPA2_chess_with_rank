package com.capgemini.chess.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.GameTO;
import com.capgemini.chess.service.to.UserTO;

public class GameMapper {

	public static GameTO map(GameEntity entity) {
		if (entity != null) {
			GameTO to = new GameTO();
			UserTO winner = UserMapper.map(entity.getWinner());
			UserTO loser = UserMapper.map(entity.getLoser());
			to.setGameId(entity.getGameId());
			to.setWinner(winner);
			to.setLoser(loser);
			to.setWinnerPoints(entity.getWinnerPoints());
			to.setLoserPoints(entity.getLoserPoints());
			AbstractMapper.mapEntity(entity, to);
			return to;
		}
		return null;
	}

	public static GameEntity map(GameTO to) {
		if (to != null) {
			GameEntity entity = new GameEntity();
			UserEntity winner = UserMapper.map(to.getWinner());
			UserEntity loser = UserMapper.map(to.getLoser());
			entity.setGameId(to.getGameId());
			entity.setWinner(winner);
			entity.setLoser(loser);
			entity.setWinnerPoints(to.getWinnerPoints());
			entity.setLoserPoints(to.getLoserPoints());
			AbstractMapper.mapTO(entity, to);
			return entity;
		}
		return null;
	}

	public static List<GameTO> map2TOs(List<GameEntity> entities) {
		return entities.stream().map(GameMapper::map).collect(Collectors.toList());
	}

	public static List<GameEntity> map2Entities(List<GameTO> tos) {
		return tos.stream().map(GameMapper::map).collect(Collectors.toList());
	}

}
