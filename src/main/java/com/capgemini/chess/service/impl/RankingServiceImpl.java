package com.capgemini.chess.service.impl;

import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.dao.GameDao;
import com.capgemini.chess.dao.RankDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.RankEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.mapper.GameMapper;
import com.capgemini.chess.mapper.RankMapper;
import com.capgemini.chess.service.RankingService;
import com.capgemini.chess.service.to.GameTO;
import com.capgemini.chess.service.to.RankTO;

@Service
@Transactional
public class RankingServiceImpl extends AbstractService<GameEntity, Long> implements RankingService {

	@Autowired
	RankDao rankDao;

	@Autowired
	UserDao userDao;

	@Autowired
	GameDao gameDao;

	@Override
	public int getRankingPositionForUser(Long userId) {

		List<UserEntity> inputSet = userDao.findByIdAndSortByScore(userId);
		for (int i = 0; i < inputSet.size(); i++) {
			UserEntity ue = inputSet.get(i);
			if (ue.getId().equals(userId)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public List<RankTO> getRankingList() {
		List<RankEntity> inputSet = rankDao.findAll();
		Collections.sort(inputSet, (u1, u2) -> Integer.compare(u2.getScore(), u1.getScore()));
		return RankMapper.map2TOs(inputSet);
	}

	@Override
	public int getScoreForUser(Long userId) {
		return userDao.findOne(userId).getScore();
	}

	public List<GameTO> findAllGamesForUser(Long id) {
		List<GameEntity> resultList = gameDao.getAllGamesForUser(id);
		return GameMapper.map2TOs(resultList);
	}

}
