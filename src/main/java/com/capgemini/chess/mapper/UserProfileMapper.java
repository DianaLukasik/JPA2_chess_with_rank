package com.capgemini.chess.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.capgemini.chess.dataaccess.entities.UserProfileEntity;
import com.capgemini.chess.service.to.UserProfileTO;

public class UserProfileMapper {

	public static UserProfileTO map(UserProfileEntity entity) {
		if (entity != null) {
			UserProfileTO to = new UserProfileTO();
			to.setId(entity.getId());
			to.setEmail(entity.getEmail());
			to.setName(entity.getName());
			to.setSurname(entity.getSurname());
			to.setAboutMe(entity.getAboutMe());
			to.setLifeMotto(entity.getLifeMotto());
			return to;
		}
		return null;
	}

	public static UserProfileEntity map(UserProfileTO to) {
		if (to != null) {
			UserProfileEntity entity = new UserProfileEntity();
			entity.setId(to.getId());
			entity.setEmail(to.getEmail());
			entity.setName(to.getName());
			entity.setSurname(to.getSurname());
			entity.setAboutMe(to.getAboutMe());
			entity.setLifeMotto(to.getLifeMotto());
			return entity;
		}
		return null;
	}

	public static List<UserProfileTO> map2TOs(List<UserProfileEntity> entities) {
		return entities.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}

	public static List<UserProfileEntity> map2Entities(List<UserProfileTO> tos) {
		return tos.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}
}
