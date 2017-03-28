package com.capgemini.chess.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.dao.UserProfileDao;
import com.capgemini.chess.dataaccess.entities.UserProfileEntity;
import com.capgemini.chess.mapper.UserProfileMapper;
import com.capgemini.chess.service.ProfileUpdateService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
@Transactional
public class ProfileUpdateServiceImpl extends AbstractService<UserProfileEntity, Long> implements ProfileUpdateService {

	@Autowired
	private UserProfileDao userProfileDao;

	@Override
	public UserProfileEntity profileUpdate(UserProfileTO profile) {
		UserProfileEntity profile2 = UserProfileMapper.map(profile);
		return userProfileDao.update(profile2);
	}

}
