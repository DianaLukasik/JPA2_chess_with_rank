package com.capgemini.chess.service.to;

public class UserTO {

	private Long id;
	private String login;
	private String password;
	private UserProfileTO profile;
	private int score;
	private GameTO game;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public UserProfileTO getProfile() {
		return profile;
	}

	public void setProfile(UserProfileTO profile) {
		this.profile = profile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public GameTO getGame() {
		return game;
	}

	public void setGame(GameTO game) {
		this.game = game;
	}
}
