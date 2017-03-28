package com.capgemini.chess.service.impl;

import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.RankDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class RankingServiceImplTest {

	@Autowired
	RankDao rankDao;

	@Test
	public void shouldGetUserScore() {
		// given
		// when
		// then
	}

	@Test
	public void shouldGetUserRankPosition() {
		// given
		// when
		// then
	}

	@Test
	public void shouldGetRanking() {
		// given
		// when
		// then

	}

	@Test
	public void shouldGetGamesListForUser() {
		// given
		// when
		// then
	}
}
