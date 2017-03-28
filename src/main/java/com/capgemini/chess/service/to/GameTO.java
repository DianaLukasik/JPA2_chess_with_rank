package com.capgemini.chess.service.to;

public class GameTO extends AbstractTO {

	private Long gameId;
	private UserTO loser;
	private UserTO winner;
	private int winnerPoints;
	private int loserPoints;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public UserTO getLoser() {
		return loser;
	}

	public void setLoser(UserTO loser) {
		this.loser = loser;
	}

	public UserTO getWinner() {
		return winner;
	}

	public void setWinner(UserTO winner) {
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

	public GameTO() {
		super();
	}

	public GameTO(Long gameId, UserTO loser, UserTO winner, int winnerPoints, int loserPoints) {
		super();
		this.gameId = gameId;
		this.loser = loser;
		this.winner = winner;
		this.winnerPoints = winnerPoints;
		this.loserPoints = loserPoints;
	}
}
