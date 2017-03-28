package com.capgemini.chess.service.impl;

import static org.junit.Assert.*;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.UserUpdateService;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UserUpdateServiceImplTest {

	@Autowired
	UserDao userDao;

	@Autowired
	UserValidationService validationService;

	@Autowired
	UserUpdateService userUpdateService;

	@Test
	public void shouldUpdateUser() throws UserValidationException {
		// given
		UserTO toUpdate = updatedUserTO();

		// when
		userUpdateService.update(toUpdate);

		// then
		assertEquals("Mirek", userDao.findOne(toUpdate.getId()).getLogin());

	}

	private UserTO updatedUserTO() {
		UserTO user = new UserTO();
		user.setId(1L);
		user.setPassword("xoxoxoxo");
		user.setLogin("Mirek");
		return user;
	}

}
