package com.capgemini.chess.dataaccess.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "game")
public class GameEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_game")
	private Long gameId;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loser")
	private UserEntity loser;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "winner")
	private UserEntity winner;
	@NotNull
	@Column(name = "loser_points", columnDefinition = "int default 0")
	private int loserPoints;
	@NotNull
	@Column(name = "winner_points", columnDefinition = "int default 0")
	private int winnerPoints;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public UserEntity getLoser() {
		return loser;
	}

	public void setLoser(UserEntity loser) {
		this.loser = loser;
	}

	public UserEntity getWinner() {
		return winner;
	}

	public void setWinner(UserEntity winner) {
		this.winner = winner;
	}

	public int getWinnerPoints() {
		return winnerPoints;
	}

	public void setWinnerPoints(int winnerPoints) {
		this.winnerPoints = winnerPoints;
	}

	public int getLoserPoints() {
		return loserPoints;
	}

	public void setLoserPoints(int loserPoints) {
		this.loserPoints = loserPoints;
	}

}
