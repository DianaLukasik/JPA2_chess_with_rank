package com.capgemini.chess.service;

import java.util.List;
import com.capgemini.chess.service.to.RankTO;

public interface RankingService {

	List<RankTO> getRankingList();

	int getRankingPositionForUser(Long userId);

	int getScoreForUser(Long userId);

}
