package com.capgemini.chess.service.to;

public class RankTO {

	UserTO user;
	int score;

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public RankTO(UserTO user, int score) {
		super();
		this.user = user;
		this.score = score;
	}

	public RankTO() {

	}

}
