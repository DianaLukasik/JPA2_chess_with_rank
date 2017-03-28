package com.capgemini.chess.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {

	@Override
	public List<UserEntity> findByIdAndSortByScore(Long userId) {
		TypedQuery<UserEntity> query = entityManager
				.createQuery("SELECT user FROM UserEntity user WHERE userId=:userId GROUP BY score", UserEntity.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public UserEntity findByLogin(String login) {
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"select user from UserEntity user where upper(login) like concat(upper(:login),'%')", UserEntity.class);
		query.setParameter("login", login);
		List<UserEntity> results = query.getResultList();
		if (results == null || results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}

}
