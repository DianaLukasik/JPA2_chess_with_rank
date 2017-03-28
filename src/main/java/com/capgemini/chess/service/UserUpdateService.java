package com.capgemini.chess.service;

import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserUpdateService {

	void update(UserTO user) throws UserValidationException;

	void profileUpdate(UserProfileTO profile);

	void validate(UserTO user) throws UserValidationException;

}
