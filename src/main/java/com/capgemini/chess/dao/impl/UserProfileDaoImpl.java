package com.capgemini.chess.dao.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.UserProfileDao;
import com.capgemini.chess.dataaccess.entities.UserProfileEntity;

@Repository
@Transactional
public class UserProfileDaoImpl extends AbstractDao<UserProfileEntity, Long> implements UserProfileDao {

}
