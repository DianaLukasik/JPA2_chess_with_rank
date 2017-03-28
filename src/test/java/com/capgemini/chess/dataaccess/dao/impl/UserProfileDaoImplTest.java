package com.capgemini.chess.dataaccess.dao.impl;

import static org.junit.Assert.*;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.impl.UserProfileDaoImpl;
import com.capgemini.chess.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UserProfileDaoImplTest {

	@Autowired
	private UserProfileDaoImpl profileDao;

	@Test
	public void shouldUpdateUserProfileIntoDataSource() {
		// given
		UserProfileTO profile = new UserProfileTO();
		profile.setId(10L);
		profile.setName("ZmienioneImie");

		// when

		profileDao.update(UserProfileMapper.map(profile));

		// then
		assertEquals("ZmienioneImie", profileDao.findOne(10L).getName());
	}
}