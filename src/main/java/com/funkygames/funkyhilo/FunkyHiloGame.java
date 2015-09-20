package com.funkygames.funkyhilo;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.ReplayChoice;
import com.funkygames.funkyhilo.exception.InvalidChoiceException;
import com.funkygames.funkyhilo.model.Card;
import com.funkygames.funkyhilo.model.Game;
import com.funkygames.funkyhilo.model.GameResult;
import com.funkygames.funkyhilo.services.ConsoleMessageService;
import com.funkygames.funkyhilo.services.GameService;
import com.funkygames.funkyhilo.services.HiLoGameService;
import com.funkygames.funkyhilo.services.MessageService;

public class FunkyHiloGame {

	public static void main(String[] args) throws InvalidChoiceException {

		MessageService messageService = new ConsoleMessageService();
		GameService gameService = new HiLoGameService();
		
		do{
			playGame(messageService, gameService);
			messageService.displayMessage("Do you want to play again?");
			ReplayChoice replayChoice = messageService.getReplayChoice();
			
			if (replayChoice == ReplayChoice.No){
				messageService.displayMessage("Good bye!");
				break;
			}
		}while (true);
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
