package com.capgemini.chess.dataaccess.source.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.dataaccess.entities.UserProfileEntity;
import com.capgemini.chess.dataaccess.source.MapDataSource;

@Component
public class MapDataSourceImpl implements MapDataSource {

	private Map<Long, UserEntity> users = new HashMap<Long, UserEntity>();

	@Override
	public Map<Long, UserEntity> getUsers() {
		return users;
	}

	private Map<Long, UserProfileEntity> profiles = new HashMap<Long, UserProfileEntity>();

	@Override
	public Map<Long, UserProfileEntity> getProfiles() {
		return profiles;
	}

	private Map<Long, GameEntity> games = new HashMap<Long, GameEntity>();

	@Override
	public Map<Long, GameEntity> getAllGames() {
		return games;
	}

	@Override
	public List<UserEntity> findAllUsers() {
		return (List<UserEntity>) users.values();

	}

}
