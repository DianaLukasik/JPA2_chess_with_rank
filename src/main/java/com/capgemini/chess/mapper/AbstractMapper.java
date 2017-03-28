package com.capgemini.chess.mapper;

import com.capgemini.chess.dataaccess.entities.AbstractEntity;
import com.capgemini.chess.service.to.AbstractTO;

public class AbstractMapper {

	public static void mapEntity(AbstractEntity source, AbstractTO target) {
		target.setCreateDate(source.getCreateDate());
		target.setVersion(source.getVersion());
		target.setModifyDate(source.getModifyDate());
	}

	public static void mapTO(AbstractEntity source, AbstractTO target) {
		source.setCreateDate(target.getCreateDate());
		source.setVersion(target.getVersion());
		source.setModifyDate(target.getModifyDate());
	}
}
