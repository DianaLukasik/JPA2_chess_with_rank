package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.mapper.UserMapper;
import com.capgemini.chess.service.UserServiceFacade;
import com.capgemini.chess.service.to.RankTO;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserTO;

@Service
@Transactional
public class UserServiceFacadeImpl implements UserServiceFacade {

	@Autowired
	UserUpdateServiceImpl userUpdateService;

	@Autowired
	RankingServiceImpl rankingService;

	@Autowired
	ProfileUpdateServiceImpl profileUpdateService;

	@Autowired
	GameServiceImpl gameService;

	@Autowired
	UserDao userDao;

	@Override
	public void update(UserTO user) throws UserValidationException {

		userUpdateService.update(user);
	}

	@Override
	public int showRankPositionForUser(Long userId) {

		return rankingService.getRankingPositionForUser(userId);
	}

	@Override
	public List<RankTO> getRankingList() {

		return rankingService.getRankingList();
	}

	@Override
	public void profileUpdate(UserProfileTO profile) {
		profileUpdateService.profileUpdate(profile);

	}

	@Override
	public UserProfileTO showUserProfile(Long userId) {
		UserTO user = UserMapper.map(userUpdateService.findOne(userId));
		return user.getProfile();
	}

	public Set<GameEntity> showAllGamesForUser(Long userId) {
		return gameService.getGameSetForUser(userId);
	}

	@Override
	public UserTO findUser(Long id) throws UserNotFoundException {
		UserEntity readUser = userDao.findOne(id);
		if (readUser == null) {
			throw new UserNotFoundException();
		} else {
			return UserMapper.map(userDao.findOne(id));
		}
	}
}
