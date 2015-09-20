package com.funkygames.funkyhilo.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.exception.InvalidChoiceException;
import com.funkygames.funkyhilo.model.Card;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;
import com.funkygames.funkyhilo.services.ConsoleMessageService;
import com.funkygames.funkyhilo.services.GameService;
import com.funkygames.funkyhilo.services.HiLoGameService;
import com.funkygames.funkyhilo.services.MessageService;
import com.funkygames.funkyhilo.services.WebMessageService;

public class FunkyHiloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		MessageService messageService = new WebMessageService(req, resp);
		GameService gameService = new HiLoGameService();
		
		try {
			playGame(messageService,gameService);
		} catch (InvalidChoiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write("hello web!");
	}
	
	private static void playGame(MessageService messageService,
			GameService gameService) throws InvalidChoiceException {
		//1 start a new game
		Game game = gameService.startGame();
		Card firstCard = game.getFirstCard();

		// 2 - display the first card to the user
		messageService.displayMessage("First Card: " + firstCard);

		// 3 - prompt the player for their choice
		messageService.displayMessage("Is the next card Hi or Lo?");
		Choice playerChoice = messageService.getPlayerChoice();
		messageService.displayMessage("user entered: " + playerChoice);

		// 4 - display the second card to the user
		Card secondCard = game.getSecondCard();
		messageService.displayMessage("Second Card: " + secondCard);

		//5. end the game and decide the outcome
		GameResult result = gameService.endGame(game, playerChoice);
		
		//6 display the outcome to the player
		messageService.displayMessage("You " + result.getResult() + "!");
	}
}
