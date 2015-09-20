package com.funkygames.funkyhilo.services;

import java.util.Scanner;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.ReplayChoice;
import com.funkygames.funkyhilo.exception.InvalidChoiceException;

public class ConsoleMessageService implements MessageService {
	private Scanner scanner = new Scanner(System.in);
	
	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public Choice getPlayerChoice() throws InvalidChoiceException {
		String input = scanner.nextLine();
		Choice playerChoice = Choice.parse(input);
		
		return playerChoice;
	}

	@Override
	public ReplayChoice getReplayChoice() {
		String input = scanner.nextLine();
		ReplayChoice replayChoice = ReplayChoice.valueOf(input);
		
		return replayChoice;
	}
	
	
}
