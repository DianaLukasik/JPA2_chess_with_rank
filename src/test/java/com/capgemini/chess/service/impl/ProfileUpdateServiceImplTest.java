package com.capgemini.chess.service.impl;

import static org.junit.Assert.assertEquals;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.UserProfileDao;
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class ProfileUpdateServiceImplTest {

	@Autowired
	UserProfileDao profileDao;

	@Autowired
	UserUpdateServiceImpl userService;

	@Test
	public void shouldUpdateUserProfile() {
		// given
		UserProfileTO profileToUpdate = updatedProfileTO();

		// when
		userService.profileUpdate(profileToUpdate);

		// then
		assertEquals("Jadzia", profileDao.findOne(1L).getName());

	}

	private UserProfileTO updatedProfileTO() {
		UserProfileTO profile = new UserProfileTO();
		profile.setId(1L);
		profile.setName("Jadzia");
		profile.setSurname("Cebula");
		profile.setEmail("mail@ma.pl");
		profile.setAboutMe("blablabla");
		profile.setLifeMotto("ojtam ojtam");
		return profile;
	}

}