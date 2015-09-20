package com.funkygames.funkyhilo.services;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.Result;
import com.funkygames.funkyhilo.model.Card;
import com.funkygames.funkyhilo.model.Dealer;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;

public class HiLoGameService implements GameService {

	@Override
	public Game startGame() {

		Game game = new Game();
		// 1.1 - create dealer
		Dealer dealer = new Dealer();

		// 2 - deal first card
		Card firstCard = dealer.deal();
		game.setFirstCard(firstCard);

		Card secondCard = dealer.deal();
		game.setSecondCard(secondCard);

		return game;
	}

	@Override
	public GameResult endGame(Game game, Choice playerChoice) {
		
		GameResult gameResult = new GameResult();
		gameResult.setGame(game);
		gameResult.setPlayerChoice(playerChoice);
		
		Choice gameOutcome = game.getOutcome();
		gameResult.setOutcome(gameOutcome);

		Result result = determineGameResult(playerChoice, gameOutcome);
		gameResult.setResult(result);
		
		return gameResult;
	}

	private Result determineGameResult(Choice playerChoice, Choice gameOutcome) {
		Result result;
		if (playerChoice == gameOutcome) {
			result = Result.WON;

		} else {
			result = Result.LOST;

		}
		return result;
	}

}
