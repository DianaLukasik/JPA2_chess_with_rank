package com.capgemini.chess.service;

import com.capgemini.chess.dataaccess.entities.UserProfileEntity;
import com.capgemini.chess.service.to.UserProfileTO;

public interface ProfileUpdateService {
	UserProfileEntity profileUpdate(UserProfileTO profile);
}
