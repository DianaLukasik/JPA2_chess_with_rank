package com.capgemini.chess.service.impl;

import static org.junit.Assert.*;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.chess.dao.impl.GameDaoImpl;
import com.capgemini.chess.dao.impl.UserDaoImpl;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.mapper.UserMapper;
import com.capgemini.chess.service.to.GameTO;
import com.capgemini.chess.service.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class GameServiceImplTest {

	@Autowired
	GameDaoImpl gameDao;

	@Autowired
	UserDaoImpl userDao;

	@Autowired
	GameServiceImpl gameService;

	@Test
	public void shouldUpdateUserScore() {
		// given
		UserTO loser = new UserTO();
		loser.setId(1L);
		UserTO winner = new UserTO();
		winner.setId(2L);
		GameTO game = new GameTO();
		game.setLoser(loser);
		game.setWinner(winner);
		game.setLoserPoints(1);
		game.setWinnerPoints(20);

		// when
		gameService.addNewGame(game);

		// then
		assertEquals(100, userDao.findOne(1L).getScore());
	}

	@Test
	public void shouldUpdateUserGameHistory() {
		// given
		UserTO loser = new UserTO();
		loser.setId(1L);
		UserTO winner = new UserTO();
		winner.setId(2L);
		GameTO newGame = new GameTO();
		newGame.setLoser(loser);
		newGame.setWinner(winner);
		newGame.setLoserPoints(1);
		newGame.setWinnerPoints(20);

		// when
		gameService.addNewGame(newGame);
		gameService.updatePlayersGameHistory();

		// then
		assertEquals(5, userDao.findOne(1L).getGameSet().size());
	}

	@Test
	public void shouldAddNewGame() {
		// given
		UserTO userX = UserMapper.map(userDao.findOne(3L));
		UserTO userY = UserMapper.map(userDao.findOne(4L));
		GameTO newGame = new GameTO();
		newGame.setLoser(userX);
		newGame.setWinner(userY);
		newGame.setLoserPoints(1);
		newGame.setWinnerPoints(20);

		// when
		gameService.addNewGame(newGame);
		List<GameEntity> testGameList = gameDao.findAll();

		// then
		assertEquals(5, testGameList.size());

	}
}
