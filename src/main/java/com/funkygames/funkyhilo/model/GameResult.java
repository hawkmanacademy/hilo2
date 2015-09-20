package com.funkygames.funkyhilo.model;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.Result;

public class GameResult {
	private Game game;
	
	private Choice outcome;
	
	private Choice playerChoice;
	
	private Result result;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Choice getOutcome() {
		return outcome;
	}

	public void setOutcome(Choice outcome) {
		this.outcome = outcome;
	}

	public Choice getPlayerChoice() {
		return playerChoice;
	}

	public void setPlayerChoice(Choice playerChoice) {
		this.playerChoice = playerChoice;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	
}
