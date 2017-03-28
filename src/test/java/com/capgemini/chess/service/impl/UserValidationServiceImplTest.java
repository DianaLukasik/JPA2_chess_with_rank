package com.capgemini.chess.service.impl;

import javax.transaction.Transactional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UserValidationServiceImplTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Autowired
	UserDao userDao;

	@Autowired
	UserValidationService validationService;

	@Test
	public void shouldThrowExceptionWhenLoginAlreadyExists() throws UserValidationException {
		// given
		String login = "ktostam";
		UserTO user = new UserTO();
		user.setLogin(login);
		userDao.findByLogin(user.getLogin());

		// expect
		exception.expect(UserValidationException.class);
		exception.expectMessage("User with given login already exist");

		// when
		validationService.validateLogin(user);
	}

	@Test
	public void shouldThrowExceptionWhenPasswordShorterThan8Characters() throws UserValidationException {
		// given
		UserTO user = new UserTO();
		user.setPassword("111");

		// expect
		exception.expect(UserValidationException.class);
		exception.expectMessage("Too short password");

		// when
		validationService.validatePassword(user);
	}
}
