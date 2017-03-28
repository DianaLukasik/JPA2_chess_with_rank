package com.capgemini.chess.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.mapper.UserMapper;
import com.capgemini.chess.service.ProfileUpdateService;
import com.capgemini.chess.service.UserUpdateService;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserTO;

@Service
@Transactional
public class UserUpdateServiceImpl extends AbstractService<UserEntity, Long> implements UserUpdateService {

	@Autowired
	private UserValidationService userValidationService;

	@Autowired
	private ProfileUpdateService profileUpdateService;

	@Autowired
	private UserDao userDao;

	@Override
	public void validate(UserTO user) throws UserValidationException {
		userValidationService.validate(user);
	}

	@Override
	public void update(UserTO user) throws UserValidationException {
		userValidationService.validate(user);
		UserEntity user1 = UserMapper.map(user);
		userDao.update(user1);
	}

	@Override
	public void profileUpdate(UserProfileTO profile) {
		profileUpdateService.profileUpdate(profile);
	}
}
