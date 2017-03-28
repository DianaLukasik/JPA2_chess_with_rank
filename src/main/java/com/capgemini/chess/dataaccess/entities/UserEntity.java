package com.capgemini.chess.dataaccess.entities;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_game")
	private Long userId;
	@Column
	@NotNull
	private String login;
	@Column
	@NotNull
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_profile", referencedColumnName = "id_profile")
	private UserProfileEntity userProfile;
	@Column
	@NotNull
	private int score;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "games_list", referencedColumnName = "id_game")
	private Set<GameEntity> gameSet;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfileEntity getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileEntity userProfile) {
		this.userProfile = userProfile;

	}

	public void addPoints(int points) {
		this.score += points;
	}

	public Set<GameEntity> getGameSet() {
		return gameSet;
	}

	public void setGameSet(Set<GameEntity> gameSet) {
		this.gameSet = gameSet;
	}

}