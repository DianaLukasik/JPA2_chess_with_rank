package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.to.RankTO;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserServiceFacade {

	void update(UserTO user) throws UserValidationException;

	void profileUpdate(UserProfileTO profile);

	UserProfileTO showUserProfile(Long userId);

	List<RankTO> getRankingList();

	int showRankPositionForUser(Long userId);

	UserTO findUser(Long id) throws UserNotFoundException;
}
