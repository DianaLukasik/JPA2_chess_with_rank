package com.capgemini.chess.dataaccess.source;

import java.util.List;
import java.util.Map;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.entities.UserProfileEntity;

public interface MapDataSource {
	Map<Long, UserEntity> getUsers();

	Map<Long, UserProfileEntity> getProfiles();

	Map<Long, GameEntity> getAllGames();

	List<UserEntity> findAllUsers();

}
