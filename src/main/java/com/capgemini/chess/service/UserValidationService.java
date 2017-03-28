package com.capgemini.chess.service;

import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.to.UserTO;

public interface UserValidationService {
	void validate(UserTO user) throws UserValidationException;

	void validateLogin(UserTO user) throws UserValidationException;

	void validatePassword(UserTO user) throws UserValidationException;
}
