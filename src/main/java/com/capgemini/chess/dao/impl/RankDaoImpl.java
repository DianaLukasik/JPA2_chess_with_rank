package com.capgemini.chess.dao.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.RankDao;
import com.capgemini.chess.dataaccess.entities.RankEntity;

@Repository
@Transactional
public class RankDaoImpl extends AbstractDao<RankEntity, Long> implements RankDao {

}
