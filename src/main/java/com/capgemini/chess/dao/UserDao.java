package com.capgemini.chess.dao;

import java.util.List;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public interface UserDao extends Dao<UserEntity, Long> {

	List<UserEntity> findByIdAndSortByScore(Long id);

	UserEntity findByLogin(String login);
}
