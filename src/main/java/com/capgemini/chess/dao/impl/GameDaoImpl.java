package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.GameDao;
import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;

@Repository
@Transactional
public class GameDaoImpl extends AbstractDao<GameEntity, Long> implements GameDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<GameEntity> getAllGamesForUser(Long id) {
		Query query = entityManager.createNamedQuery(
				"SELECT game FROM GameEntity game INNER JOIN UserEntity user WHERE game.loser.userId=:id OR game.userId.winner=:id ",
				UserEntity.class);
		query.setParameter("userId", id);
		List<GameEntity> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<GameEntity> findGameWithCriteriaBuilder(Integer winnerPoints, Integer loserPoints, UserEntity winner,
			UserEntity loser) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GameEntity> query = cb.createQuery(GameEntity.class);
		Root<GameEntity> root = query.from(GameEntity.class);
		Predicate predicateWinnerPoints = cb.equal(root.get("winnerPoints"), winnerPoints);
		Predicate predicateLoserPoints = cb.equal(root.get("loserPoints"), loserPoints);
		Predicate predicateWinner = cb.equal(root.get("winner"), winner);
		Predicate predicateLoser = cb.equal(root.get("loser"), loser);

		List<Predicate> criteria = new ArrayList<Predicate>();
		if (winnerPoints != null) {
			criteria.add(predicateWinnerPoints);
		}
		if (loserPoints != null) {
			criteria.add(predicateLoserPoints);
		}
		if (winner != null) {
			criteria.add(predicateWinner);
		}
		if (loser != null) {
			criteria.add(predicateLoser);
		}

		query.where(criteria.toArray(new Predicate[] {}));

		List<GameEntity> resultList = entityManager.createQuery(query).getResultList();
		return resultList;

	}
}