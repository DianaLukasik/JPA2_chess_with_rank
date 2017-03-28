package com.capgemini.chess.service.impl;

import static org.junit.Assert.*;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.UserProfileDao;
import com.capgemini.chess.dao.impl.UserDaoImpl;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.GameService;
import com.capgemini.chess.service.UserUpdateService;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.to.RankTO;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UserServiceFacadeImplTest {

	@Autowired
	UserDaoImpl userDao;

	@Autowired
	UserServiceFacadeImpl userServiceFacade;

	@Autowired
	UserUpdateServiceImpl userService;

	@Autowired
	UserValidationService validationService;

	@Autowired
	UserProfileDao profileDao;

	@Autowired
	UserUpdateService userUpdateService;

	@Autowired
	GameService gameService;

	@Test
	public void shouldReturn1User() throws UserNotFoundException {
		assertNotNull(userServiceFacade.findUser(1L));
	}

	@Test(expected = UserNotFoundException.class)
	public void shouldThrowExpectionIfUserDoNotExist() throws UserNotFoundException {
		// when
		userServiceFacade.findUser(19L);
	}

	@Test
	public void shouldUpdateUser() throws UserValidationException {
		// given
		UserTO toUpdate = updatedUserTO();

		// when
		userServiceFacade.update(toUpdate);

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

	@Test
	public void shouldReturnUserProfile() {
		// given
		Long userId = 1L;

		// then
		assertEquals("Mirek", userServiceFacade.showUserProfile(userId).getName());

	}

	@Test(expected = EntityNotFoundException.class)
	public void shouldNotReturnUserProfile() {
		// given
		Long userId = 100L;
		userServiceFacade.showUserProfile(userId);
	}

	@Test
	public void shouldReturnRanking() {
		// when
		List<RankTO> resultSet = userServiceFacade.getRankingList();
		for (RankTO u : resultSet) {
			System.out.println(u.getScore());
		}

		// then
		assertEquals(100, resultSet.get(0).getScore());
		assertEquals(80, resultSet.get(1).getScore());
	}

	@Test
	public void shouldReturnGamesListForUser() {
		// given
		long userId = 1L;

		// then
		assertEquals(3, userServiceFacade.showAllGamesForUser(userId).size());
	}

	@Test
	public void shouldReturnUserRankPosition() {
		// given
		UserTO user = new UserTO();
		user.setId(1L);

		// when
		int position = userServiceFacade.showRankPositionForUser(1L);

		// then
		assertEquals(0, position);
	}
}
