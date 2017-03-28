package com.capgemini.chess.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.to.UserTO;

@Service
@Transactional
public class UserValidationServiceImpl implements UserValidationService {

	@Autowired
	private UserDao userDao;

	@Override
	public void validate(UserTO user) throws UserValidationException {
		validateLogin(user);
		validatePassword(user);
	}

	@Override
	public void validateLogin(UserTO user) throws UserValidationException {
		UserEntity foundUser = userDao.findByLogin(user.getLogin());
		if (foundUser != null) {
			throw new UserValidationException("User with given login already exist");
		}
	}

	@Override
	public void validatePassword(UserTO user) throws UserValidationException {
		if (user.getPassword().length() < 8) {
			throw new UserValidationException("Too short password");
		}
	}
}