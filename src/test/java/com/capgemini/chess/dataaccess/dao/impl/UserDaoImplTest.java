package com.capgemini.chess.dataaccess.dao.impl;

import static org.junit.Assert.*;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.mapper.UserMapper;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UserDaoImplTest {

	@Autowired
	UserDao dao;

	@Test
	public void shouldUpdateUser() throws UserValidationException {
		// given
		UserTO toUpdate = updatedUserTO();

		// when
		UserEntity user = UserMapper.map(toUpdate);
		dao.update(user);

		// then
		assertEquals("Mirek", dao.findOne(toUpdate.getId()).getLogin());

	}

	private UserTO updatedUserTO() {
		UserTO user = new UserTO();
		user.setId(1L);
		user.setPassword("xoxoxoxo");
		user.setLogin("Mirek");
		return user;
	}

	@Test
	public void shouldFindUserByExistingId() {
		// given
		Long id = 1L;

		// when
		dao.findOne(id);

		// then
		assertEquals("ktostam", dao.findOne(id).getLogin());

	}

	@Test(expected = UserNotFoundException.class)
	public void shouldNotFindUserWhenIdDoesNotExistAndThrowException() {
		// when
		dao.findOne(99L);

	}

}
