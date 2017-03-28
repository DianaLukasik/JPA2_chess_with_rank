package com.capgemini.chess.dataaccess.dao.impl;

import static org.junit.Assert.*;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.GameDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class GameDaoImplTest {

	@Autowired
	GameDao gameDao;

	@Autowired
	UserDao userDao;

	@Test
	public void shouldFindGameWithCriteriaBuilder() {
		// given
		Integer winnerPoints = 10;
		Integer loserPoints = 1;
		UserEntity winner = null;
		UserEntity loser = null;
		// when
		List<GameEntity> list = gameDao.findGameWithCriteriaBuilder(winnerPoints, loserPoints, winner, loser);
		// then
		assertEquals(10, list.get(0).getWinnerPoints());
	}

	@Test
	public void shouldNotFindGameWithCriteriaBuilder() {
		// given
		Integer winnerPoints = 10;
		Integer loserPoints = 11;
		Long id = 1L;
		UserEntity winner = userDao.findOne(id);
		UserEntity loser = null;
		// when
		List<GameEntity> list = gameDao.findGameWithCriteriaBuilder(winnerPoints, loserPoints, winner, loser);
		// then
		assertEquals(0, list.size());
	}

	@Test
	public void shouldFindGameWithCriteriaBuilderWithGivenOnlyWinnerCriteria() {
		// given
		Integer winnerPoints = null;
		Integer loserPoints = null;
		Long id = 1L;
		UserEntity winner = userDao.findOne(id);
		UserEntity loser = null;
		// when
		List<GameEntity> list = gameDao.findGameWithCriteriaBuilder(winnerPoints, loserPoints, winner, loser);
		// then
		assertEquals(3, list.size());
	}

}
