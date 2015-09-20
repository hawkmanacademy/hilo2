package com.funkygames.funkyhilo.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funkygames.funkyhilo.constants.Choice;
import com.funkygames.funkyhilo.constants.ReplayChoice;
import com.funkygames.funkyhilo.exception.InvalidChoiceException;

public class WebMessageService implements MessageService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	public WebMessageService(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	@Override
	public void displayMessage(String message) {
		try {
			resp.getWriter().write("hello web!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Choice getPlayerChoice() throws InvalidChoiceException {
		String userChoice = req.getParameter("choice");
		Choice choice = Choice.parse(userChoice);
		return choice;
	}

	@Override
	public ReplayChoice getReplayChoice() {
		// TODO Auto-generated method stub
		return null;
	}

}
