package com.capgemini.chess.dataaccess.dao.impl;

import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.impl.RankDaoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class RankDaoImplTest {

	@Autowired
	RankDaoImpl rankDao;

	@Test
	public void shouldGetCompleteRanking() {
		// given
		// when
		// then
	}
}
