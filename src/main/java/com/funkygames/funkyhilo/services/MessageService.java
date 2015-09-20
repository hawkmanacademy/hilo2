package com.funkygames.funkyhilo.services;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.ReplayChoice;
import com.funkygames.funkyhilo.exception.InvalidChoiceException;

public interface MessageService {
	public void displayMessage(String message);
	
	public Choice getPlayerChoice() throws InvalidChoiceException;
	
	public ReplayChoice getReplayChoice();
	
}
