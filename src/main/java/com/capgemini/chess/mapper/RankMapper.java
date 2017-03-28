package com.capgemini.chess.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.capgemini.chess.dataaccess.entities.RankEntity;
import com.capgemini.chess.service.to.RankTO;

public class RankMapper {

	public static RankTO map(RankEntity entity) {
		if (entity != null) {
			RankTO to = new RankTO();
			to.setUser(UserMapper.map(entity.getUser()));
			to.setScore(entity.getScore());
			return to;
		}
		return null;
	}

	public static RankEntity map(RankTO to) {
		if (to != null) {
			RankEntity entity = new RankEntity();
			entity.setUser(UserMapper.map(to.getUser()));

			entity.setScore(to.getScore());

			return entity;
		}
		return null;
	}

	public static List<RankTO> map2TOs(List<RankEntity> entities) {
		return entities.stream().map(RankMapper::map).collect(Collectors.toList());
	}

	public static List<RankEntity> map2Entities(List<RankTO> tos) {
		return tos.stream().map(RankMapper::map).collect(Collectors.toList());
	}

}
